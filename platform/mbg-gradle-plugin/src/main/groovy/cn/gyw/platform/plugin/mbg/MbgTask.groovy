package cn.gyw.platform.plugin.mbg

import cn.gyw.platform.plugin.mbg.engine.FreemarkerTemplateEngine
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.mybatis.generator.api.MyBatisGenerator
import org.mybatis.generator.config.xml.ConfigurationParser
import org.mybatis.generator.internal.DefaultShellCallback
import org.mybatis.generator.internal.util.StringUtility

import cn.gyw.platform.common.util.StringUtil
import cn.gyw.platform.plugin.mbg.config.ConfigBuilder

import java.nio.file.FileSystem
import java.nio.file.Paths

/**
 * Mybatis generator任务类
 */
class MbgTask extends DefaultTask {

	/**
	 * 代码生成方法
	 */
	@TaskAction
	void generate() {
		println "Mybatis generator for project [$project.name]"
		if (project.mbg.skip) {
			println ("MyBatis generator is skipped")
			return
		}
		// 1-校验参数
		checkParam(project)
		// 生成ConfigBuilder
		ConfigBuilder configBuilder = buildConfig(project)
		// 2-执行数据库脚本
		runSqlScript(project.mbg.sqlScript,	project.mbg.allTable, configBuilder)
		// 3-tableNames 变量处理
		setTableNamesValues(project, configBuilder)
		// 4-contexts 变量处理
		setContextsValues(project, configBuilder)
		// 6-MBG 生成entity、mapper、xml 文件
		configBuilder.tables.each { entry ->
			doMybatisGenerate(entry, configBuilder)
		}
		// 7-模板引擎生成通用的controller、service 代码文件
		def templateEngine = new FreemarkerTemplateEngine()
		templateEngine.init(configBuilder).mkdirs().batchOutput()
	}

	synchronized void doMybatisGenerate(Map.Entry<String, String> entry, ConfigBuilder configBuilder) {
		println "MBG for table >>${entry.getKey()}"
		List<String> warnings = new ArrayList<String>()
		try {
			def extra = new Properties()
			extra.putAll(configBuilder.xmlParams)
			extra.setProperty("xml.tableName", entry.getKey())
			extra.setProperty("xml.objectName", entry.getValue())
			extra.setProperty("xml.mapperName", entry.getValue() + extra.getProperty("xml.mapperSuffix", "Mapper"))
			def config = new ConfigurationParser(extra, warnings)
					.parseConfiguration(configBuilder.generatorFile)
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
					new DefaultShellCallback(configBuilder.overwrite), warnings)
			myBatisGenerator.generate(new GradleProgressCallback(configBuilder.consoleable),
					configBuilder.contextsToRun, configBuilder.fullyQualifiedTables)
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
	private void setTableNamesValues(Project project, ConfigBuilder configBuilder) {
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
		configBuilder.fullyQualifiedTables = fullyQualifiedTables
		println "fullyQualifiedTables=$fullyQualifiedTables"
	}

	/**
	 * 设置contexts的额外信息
	 * @param contextsToRun 参数 mbg.contexts
	 */
	private void setContextsValues(Project project, ConfigBuilder configBuilder) {
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
		configBuilder.contextsToRun = contextsToRun
		println "contextsToRun=$contextsToRun"
	}

	/**
	 * 执行数据库脚本
	 * @param sql
	 * @param jdbcUrl
	 * @param username
	 * @param password
	 * @param isAll 是否查询所有表名
	 */
	void runSqlScript(String sqlScript, boolean allTable, ConfigBuilder configBuilder) {
		//sqlScript callback
		def sqlScriptRunner = new SqlScriptRunner(sqlScript,
				configBuilder.xmlParams["jdbc.url"],
				configBuilder.xmlParams["jdbc.username"],
				configBuilder.xmlParams["jdbc.password"])
		sqlScriptRunner.execSqlScript()
		// map key:tableName->value:objectName
		def tables = [:]
		if (allTable) {
			sqlScriptRunner.getAllTableName().each { key ->
				tables[key] = StringUtil.underlineToHump(key)
			}
		} else {
			// 否，使用设置的表名填充
			tables[configBuilder.xmlParams['xml.tableName']] = configBuilder.xmlParams['xml.objectName']
		}
		configBuilder.tables = tables
		// 需要处理的模块 ObjectName集合
		configBuilder.moduleList = tables.values()
		println "tables=$tables"
	}

	/**
	 * 构建ConfigBuilder
	 * @param configBuilder 配置构建器
	 */
	private ConfigBuilder buildConfig(Project project) {
		ConfigBuilder configBuilder = new ConfigBuilder()

		configBuilder.javaProjectDir = project.file(project.mbg.xml.javaProject)
		configBuilder.resourcesProjectDir = project.file(project.mbg.xml.resourcesProject)
		// 项目根目录
		configBuilder.generatorFile = new File(project.getRootDir().getPath() + File.separator + project.mbg.generatorFile)
		configBuilder.consoleable = project.mbg.consoleable
		configBuilder.overwrite = project.mbg.overwrite
		
		// jdbc 参数
		resolveDbConfigFile(project.mbg.dbConfigPath, configBuilder)
		// xml 参数
		String basePackage = project.mbg.xml.basePackage
		configBuilder.xmlParams["xml.javaProject"] = project.getName() + File.separator + project.mbg.xml.javaProject
		configBuilder.xmlParams["xml.resourcesProject"] = project.getName() + File.separator + project.mbg.xml.resourcesProject
		configBuilder.xmlParams["xml.mapperPlugin"] = project.mbg.xml.mapperPlugin.getName()
		configBuilder.xmlParams["xml.mapperMapper"] = project.mbg.xml.mapperMapper
		configBuilder.xmlParams["xml.mapperPackage"] = basePackage + "." + project.mbg.xml?.mapperPackage
		configBuilder.xmlParams["xml.modelPackage"] = basePackage + "." + project.mbg.xml.modelPackage
		configBuilder.xmlParams["xml.xmlPackage"] = project.mbg.xml.xmlPackage
		if (StringUtility.stringHasValue(project.mbg.xml.tableName)) {
			configBuilder.xmlParams["xml.tableName"] = project.mbg.xml.tableName
			String objectName = project.mbg.xml.objectName
			if (!StringUtility.stringHasValue(objectName)) {
				// 若未指定对象名，默认根据表名生成
				objectName = StringUtil.firstLetterToUp(StringUtil.underlineToHump(project.mbg.xml.tableName))
			}
			configBuilder.xmlParams["xml.objectName"] = objectName
			configBuilder.xmlParams["xml.mapperName"] = objectName + project.mbg.xml.mapperSuffix
		}

		// ftl模板参数
		configBuilder.superServiceClass = project.mbg.ftl.superServiceClass
		configBuilder.superControllerClass = project.mbg.ftl.superControllerClass
		configBuilder.restControllerStyle = project.mbg.ftl.restControllerStyle
		configBuilder.entityPackage = basePackage + "." + project.mbg.ftl.entityPackage
		configBuilder.entityDtoPackage = basePackage + "." + project.mbg.ftl.entityDtoPackage
		configBuilder.servicePackage = basePackage + "." + project.mbg.ftl.servicePackage
		configBuilder.controllerPackage = basePackage + "." + project.mbg.ftl.controllerPackage

		println "***********参数打印 start ************"
		for (def param : configBuilder.xmlParams) {
			println "${param.key}=${param.value}"
		}
		println "entityPackage=${configBuilder.entityPackage}"
		println "entityDtoPackage=${configBuilder.entityDtoPackage}"
		println "servicePackage=${configBuilder.servicePackage}"
		println "controllerPackage=${configBuilder.controllerPackage}"
		println "***********参数打印 end ************"
		return configBuilder
	}
	
	private void resolveDbConfigFile(String dbConfigPath, ConfigBuilder configBuilder) {
		Properties dbProp = new Properties()
		InputStream input = null;
		try {
			input = new FileInputStream(dbConfigPath);
			dbProp.load(input)
		} catch (Exception e) {
			throw e
		} finally {
			if (input != null) {
				input.close()
			}
		}
		// jdbc参数
		configBuilder.xmlParams["jdbc.driver"] = dbProp.getProperty("jdbc.driver")
		configBuilder.xmlParams["jdbc.url"] = dbProp.getProperty("jdbc.url")
		configBuilder.xmlParams["jdbc.username"] = dbProp.getProperty("jdbc.username")
		configBuilder.xmlParams["jdbc.password"] = dbProp.getProperty("jdbc.password")
	}

	/**
	 * 校验参数
	 */
	private void checkParam(Project project) {
		if (!project.file(project.mbg.xml.javaProject).exists()) {
			throw new FileNotFoundException(project.file(project.mbg.xml.javaProject).getAbsolutePath())
		}
		if (!project.file(project.mbg.xml.resourcesProject).exists()) {
			throw new FileNotFoundException(project.file(project.mbg.xml.resourcesProject).getAbsolutePath())
		}
		File generatorFile = new File(project.getRootDir().getPath() + File.separator + project.mbg.generatorFile)
		if (!generatorFile.exists()) {
			throw new FileNotFoundException(generatorFile.getAbsolutePath())
		}
		if (!StringUtility.stringHasValue(project.mbg.dbConfigPath)) {
			throw new GradleException("mbg.dbConfigPath<String> 未设置，请设置后重试")
		}
		File dbConfigFile = Paths.get(project.mbg.dbConfigPath).toFile()
		if (!dbConfigFile.exists()) {
			throw new GradleException("mbg.dbConfigPath 不存在:${dbConfigFile.getAbsolutePath()}")
		}
		Class clazzPlugin = project.mbg.xml.mapperPlugin
		if (clazzPlugin == null) {
			throw new GradleException("mbg.xml.mapperPlugin<Class<? extends PluginAdapter>> 未设置,请设置后重试")
		}
		if (!StringUtility.stringHasValue(project.mbg.xml.basePackage)) {
			throw new GradleException("mbg.xml.basePackage<String> 未设置,请设置后重试")
		}
		if (!StringUtility.stringHasValue(project.mbg.xml.mapperMapper)) {
			throw new GradleException("mbg.xml.mapperMapper<String> 未设置,请设置后重试")
		}
		if (!project.mbg.allTable && !StringUtility.stringHasValue(project.mbg.xml.tableName)) {
			throw new GradleException("allTable==false && mbg.xml.tableName<String> 未设置，请设置后重试")
		}
	}
}
