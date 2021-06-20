package cn.gyw.platform.plugin.mbg

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.mybatis.generator.api.MyBatisGenerator
import org.mybatis.generator.config.xml.ConfigurationParser
import org.mybatis.generator.internal.DefaultShellCallback
import org.mybatis.generator.internal.util.StringUtility

import cn.gyw.platform.plugin.mbg.config.ConfigBuilder
import cn.gyw.platform.plugin.mbg.engine.FreemarkerTemplateEngine

class MbgTask extends DefaultTask {

	def javaProjectFile
	def resourcesProjectFile
	def generatorFile

	/**
	 * 需要设置到xml中的配置map,临时变量.
	 */
	def xmlParams = [:]

	/**
	 * mbg的主要逻辑
	 */
	@TaskAction
	void generator() {
		if (project.mbg.skip) {
			println("MyBatis generator is skipped.")
			return;
		}
		// 设置generatorConfig.xml的位置
		generatorFile = project.file(project.mbg.generatorFile)
		javaProjectFile = project.file(project.mbg.xml.javaProject)
		resourcesProjectFile = project.file(project.mbg.xml.resourcesProject)
		// 验证参数
		validationParam(project)

		//sqlScript callback
		def sqlScriptRunner = new SqlScriptRunner(project.mbg.sqlScript, project.mbg.jdbc.url, project.mbg.jdbc.username, project.mbg.jdbc.password)
		sqlScriptRunner.execSqlScript()
		def tables = [:]
		if (project.mbg.allTable) {
			sqlScriptRunner.getAllTableName().each { key ->
				tables[key] = tableNameToBigHump(key)
			}
			println "All tables on ${project.mbg.jdbc.url} :${tables}"
		} else {
			tables[xmlParams['xml.tableName']] = xmlParams['xml.objectName']
		}
		// tableNames 变量处理
		Set<String> fullyQualifiedTables = setTableNamesValues(project)
		// contexts 变量处理
		Set<String> contextsToRun = setContextsValues(project)
//		def templateEngine = new FreemarkerTemplateEngine()
		
		for (def entry : tables) {
			doMybatisGenerate(entry, fullyQualifiedTables, contextsToRun)
		}
		ConfigBuilder configBuilder = new ConfigBuilder()
		configBuilder.restControllerStyle = project.mbg.ftl.restControllerStyle
		configBuilder.controllerPackage = project.mbg.ftl.controllerPackage
		configBuilder.servicePackage = project.mbg.ftl.servicePackage
		configBuilder.superControllerClass = project.mbg.ftl.superControllerClass
		configBuilder.superServiceClass = project.mbg.ftl.superServiceClass
		configBuilder.moduleLis = tables.values()
		println ("ConfigBuilder :$configBuilder")
		
//		templateEngine.init(configBuilder).mkdirs().batchOutput()
	}

	void doMybatisGenerate(Map.Entry<String, String> entry, def fullyQualifiedTables, def contextsToRun) {
		println "MBG for table >>${entry.getKey()}"
		List<String> warnings = new ArrayList<String>()
		try {
			def extra = new Properties()
			extra.putAll(xmlParams)
			extra.setProperty("xml.tableName", entry.getKey())
			extra.setProperty("xml.objectName", entry.getValue())
			extra.setProperty("xml.mapperName", entry.getValue() + project.mbg.xml.mapperSuffix)
			def config = new ConfigurationParser(extra, warnings).parseConfiguration(generatorFile)
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					new DefaultShellCallback(project.mbg.overwrite), warnings);
			myBatisGenerator.generate(new GradleProgressCallback(project.mbg.consoleable), contextsToRun, fullyQualifiedTables);
		} catch (Exception e) {
			e.printStackTrace()
			throw new GradleException(e.getMessage(), e)
		}
		for (String error : warnings) {
			println "MBG warnings :$error";
		}
	}

	/**
	 * 设置tableNames的额外信息
	 * @param fullyqualifiedTables 参数 mbg.tableNames
	 */
	private Set<String> setTableNamesValues(Project project) {
		Set<String> fullyQualifiedTables = []
		if (StringUtility.stringHasValue(project.mbg.tableNames)) {
			StringTokenizer st = new StringTokenizer(project.mbg.tableNames, ","); 
			while (st.hasMoreTokens()) {
				String s = st.nextToken().trim();
				if (s.length() > 0) {
					fullyQualifiedTables.add(s);
				}
			}
		}
		return fullyQualifiedTables
	}

	/**
	 * 设置contexts的额外信息
	 * @param contextsToRun 参数 mbg.contexts
	 */
	private Set<String> setContextsValues(Project project) {
		Set<String> contextsToRun = []
		if (StringUtility.stringHasValue(project.mbg.contexts)) {
			StringTokenizer st = new StringTokenizer(project.mbg.contexts, ",");
			while (st.hasMoreTokens()) {
				String s = st.nextToken().trim();
				if (s.length() > 0) {
					contextsToRun.add(s);
				}
			}
		}
		return contextsToRun
	}

	/**
	 * 基础验证并且设置内容到xmlParam中去
	 */
	private void validationParam(Project project) {
		if (!generatorFile.exists()) {
			println("generatorConfig.xml该文件不存在请查找目录是否存在:${generatorFile.getAbsolutePath()}");
			throw new FileNotFoundException(generatorFile.getAbsolutePath())
		}

		def errorMsg;
		//driver
		if (!StringUtility.stringHasValue(project.mbg.jdbc.driver)) {
			errorMsg = "变量mbg.jdbc.driver<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["jdbc.driver"] = project.mbg.jdbc.driver
		//url
		if (!StringUtility.stringHasValue(project.mbg.jdbc.url)) {
			errorMsg = "变量mbg.jdbc.url<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["jdbc.url"] = project.mbg.jdbc.url

		//username
		if (!StringUtility.stringHasValue(project.mbg.jdbc.username)) {
			errorMsg = "变量mbg.jdbc.username<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["jdbc.username"] = project.mbg.jdbc.username

		//password
		if (!StringUtility.stringHasValue(project.mbg.jdbc.password)) {
			errorMsg = "变量mbg.jdbc.password<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["jdbc.password"] = project.mbg.jdbc.password

		//xml param
		if (!javaProjectFile.exists()) {
			println("javaProject目录不存在:${javaProjectFile.getAbsolutePath()}");
			throw new FileNotFoundException(javaProjectFile.getAbsolutePath())
		}
		xmlParams["xml.javaProject"] = project.mbg.xml.javaProject

		if (!resourcesProjectFile.exists()) {
			println("resourcesProject目录不存在:${resourcesProjectFile.getAbsolutePath()}");
			throw new FileNotFoundException(resourcesProjectFile.getAbsolutePath())
		}
		xmlParams["xml.resourcesProject"] = project.mbg.xml.resourcesProject

		Class clazzPlugin = project.mbg.xml.mapperPlugin
		if (clazzPlugin == null) {
			errorMsg = "变量mbg.xml.mapperPlugin<Class<? extends PluginAdapter>>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["xml.mapperPlugin"] = clazzPlugin.getName()

		if (!StringUtility.stringHasValue(project.mbg.xml.mapperMapper)) {
			errorMsg = "变量mbg.xml.mapperMapper<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["xml.mapperMapper"] = project.mbg.xml.mapperMapper
		//
		if (!StringUtility.stringHasValue(project.mbg.xml.mapperPackage)) {
			errorMsg = "变量mbg.xml.mapperPackage<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["xml.mapperPackage"] = project.mbg.xml.mapperPackage

		if (!StringUtility.stringHasValue(project.mbg.xml.modelPackage)) {
			errorMsg = "变量mbg.xml.modelPackage<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["xml.modelPackage"] = project.mbg.xml.modelPackage

		if (!StringUtility.stringHasValue(project.mbg.xml.xmlPackage)) {
			errorMsg = "变量mbg.xml.xmlPackage<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["xml.xmlPackage"] = project.mbg.xml.xmlPackage

		if (!project.mbg.allTable && !StringUtility.stringHasValue(project.mbg.xml.tableName)) {
			errorMsg = "变量mbg.xml.tableName<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		if (StringUtility.stringHasValue(project.mbg.xml.tableName)) {
			xmlParams["xml.tableName"] = project.mbg.xml.tableName			
		}

		if (!project.mbg.allTable && !StringUtility.stringHasValue(project.mbg.xml.objectName)) {
			errorMsg = "变量mbg.xml.objectName<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		if (StringUtility.stringHasValue(project.mbg.xml.objectName)) {
			xmlParams["xml.objectName"] = project.mbg.xml.objectName
			xmlParams["xml.mapperName"] = project.mbg.xml.objectName + project.mbg.xml.mapperSuffix
		}
		for (def param : xmlParams) {
			println "env param:[${param.key}:${param.value}]"
		}
	}

	/***
	 * 下划线命名转为驼峰命名
	 *
	 * @param para
	 *        下划线命名的字符串
	 */
	String tableNameToBigHump(String name) {
		if (name == null) {
			return ''
		}
		StringBuilder sb = new StringBuilder()
		String[] strs = name.toLowerCase().split("_")
		for (String s : strs) {
			sb.append(firstToUpper(s))
		}
		return sb.toString();
	}

	String firstToUpper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
