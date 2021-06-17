package cn.gyw.platform.plugin.mbg

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.mybatis.generator.api.MyBatisGenerator
import org.mybatis.generator.config.xml.ConfigurationParser
import org.mybatis.generator.internal.DefaultShellCallback
import org.mybatis.generator.internal.util.StringUtility

class MbgTask extends DefaultTask {

	def javaProjectFile
	def resourcesProjectFile
	def generatorFile
	/**
	 * 需要设置到xml中的配置map,临时变量.
	 */
	def xmlParams = [:]

	/**
	 * mbg的主要业务逻辑
	 */
	@TaskAction
	void generator() {
		if (project.mbg.skip) {
			println("MyBatis generator is skipped.")
			return;
		}
		//设置generatorConfig.xml的位置
		generatorFile = project.file(project.mbg.generatorFile)
		javaProjectFile = project.file(project.mbg.xml.javaProject)
		resourcesProjectFile = project.file(project.mbg.xml.resourcesProject)
		//验证
		validation(project)
		for (def param : xmlParams)
			println("环境变量输出:[${param.key}:${param.value}]")
		//sqlScript callback
		def sqlScriptRunner = new SqlScriptRunner(project.mbg.sqlScript, project.mbg.jdbc.url, project.mbg.jdbc.username, project.mbg.jdbc.password)
		sqlScriptRunner.execSqlScript()
		List<String> warnings = new ArrayList<String>();
		//tableNames变量的处理信息
		Set<String> fullyqualifiedTables = new HashSet<String>();
		setTableNamesValues(fullyqualifiedTables, project)
		//contexts变量的处理信息
		Set<String> contextsToRun = new HashSet<String>();
		setContextsValues(contextsToRun, project)
		try {
			def extra = new Properties()
			extra.putAll(xmlParams)
			def config = new ConfigurationParser(extra, warnings).parseConfiguration(generatorFile)
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					new DefaultShellCallback(project.mbg.overwrite), warnings);

			myBatisGenerator.generate(new GradleProgressCallback(project.mbg.consoleable), contextsToRun, fullyqualifiedTables);
		} catch (Exception e) {
			throw new GradleException(e.getMessage(), e);
		}
		for (String error : warnings) {
			println(error);
		}
	}

	/**
	 * 设置tableNames的额外信息
	 * @param fullyqualifiedTables 参数 mbg.tableNames
	 */
	private void setTableNamesValues(Set<String> fullyqualifiedTables, Project project) {
		if (StringUtility.stringHasValue(project.mbg.tableNames)) {
			StringTokenizer st = new StringTokenizer(project.mbg.tableNames, ","); //$NON-NLS-1$
			while (st.hasMoreTokens()) {
				String s = st.nextToken().trim();
				if (s.length() > 0) {
					fullyqualifiedTables.add(s);
				}
			}
		}
	}

	/**
	 * 设置contexts的额外信息
	 * @param contextsToRun 参数 mbg.contexts
	 */
	private void setContextsValues(Set<String> contextsToRun, Project project) {
		if (StringUtility.stringHasValue(project.mbg.contexts)) {
			StringTokenizer st = new StringTokenizer(project.mbg.contexts, ","); //$NON-NLS-1$
			while (st.hasMoreTokens()) {
				String s = st.nextToken().trim();
				if (s.length() > 0) {
					contextsToRun.add(s);
				}
			}
		}
	}

	/**
	 * 基础验证并且设置内容到xmlParam中去
	 */
	private void validation(Project project) {
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

		if (!StringUtility.stringHasValue(project.mbg.xml.tableName)) {
			errorMsg = "变量mbg.xml.tableName<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["xml.tableName"] = project.mbg.xml.tableName

		if (!StringUtility.stringHasValue(project.mbg.xml.objectName)) {
			errorMsg = "变量mbg.xml.objectName<String>未设置,请设置后重试."
			println(errorMsg)
			throw new GradleException(errorMsg)
		}
		xmlParams["xml.objectName"] = project.mbg.xml.objectName

		xmlParams["xml.mapperName"] = project.mbg.xml.objectName+project.mbg.xml.mapperSuffix
	}
}
