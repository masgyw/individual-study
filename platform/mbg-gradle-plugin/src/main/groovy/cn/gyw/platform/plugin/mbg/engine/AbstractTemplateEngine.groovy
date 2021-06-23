package cn.gyw.platform.plugin.mbg.engine

import cn.gyw.platform.plugin.mbg.config.ConfigBuilder
import cn.gyw.platform.plugin.mbg.config.OutputFile

import java.nio.file.Paths

abstract class AbstractTemplateEngine {

	/**
	 * 配置信息
	 */
	ConfigBuilder configBuilder
	
	/**
	 * <p>
	 * 模板引擎初始化
	 * </p>
	 */
	AbstractTemplateEngine init(ConfigBuilder configBuilder) {
		this.configBuilder = configBuilder
		configBuilder.pathInfo[OutputFile.CONTROLLER]=configBuilder.controllerPackage.replace(".", "/")
		configBuilder.pathInfo[OutputFile.SERVICE]=configBuilder.servicePackage.replace(".", "/")
		return this
	}
	
	/**
	 * 生成文件
	 */
	void batchOutput() {
		configBuilder.moduleList.each { module ->
			Map<String, Object> objectMap = this.getObjectMap(configBuilder, module)
			// *Service.java
//			outputService(objectMap)
			// *Controller.java
			outputController(objectMap)
		}
	}

	void outputService(Map<String, Object> objectMap) {
		// MpController.java
		String controllerPath = getPathInfo(OutputFile.SERVICE)
		if (!controllerPath.endsWith("/")) {
			controllerPath += "/"
		}
		String controllerFile = String.format(controllerPath + "%s.java", objectMap.get("serviceName"))
		writer(objectMap, "service.java.ftl", controllerFile);
	}

	void outputController(Map<String, Object> objectMap) {
		// MpController.java
		String controllerPath = getPathInfo(OutputFile.CONTROLLER)
		if (!controllerPath.endsWith("/")) {
			controllerPath += "/"
		}
		String srcPath = configBuilder.javaProjectFile.getAbsolutePath()
		String fileName = String.format(controllerPath + "%s.java", objectMap.get("controllerName"))
		println "controllerFile :$srcPath/$fileName"
		writer(objectMap, "controller.java.ftl", srcPath + "/" + fileName);
	}

	def getObjectMap(ConfigBuilder config, String module) {
		Map<String, Object> objectMap = [:]
		objectMap.put("restControllerStyle", configBuilder.restControllerStyle)
		objectMap.put("controllerPackage", configBuilder.controllerPackage)
		objectMap.put("superControllerClassPackage", configBuilder.superControllerClass)
		def superControllerClass =
				configBuilder.superControllerClass.substring(configBuilder.superControllerClass.lastIndexOf(".") + 1)
		objectMap.put("superControllerClass", superControllerClass)
		objectMap.put("moduleName", module)
		objectMap.put("controllerName", String.format("%sController", module))
		objectMap.put("serviceName", String.format("%sService", module))
		objectMap.put("entityClassPackage", configBuilder.entityPackage + "." + module)
		def dtoName = String.format("%sDto", module)
		objectMap.put("entityDtoClassPackage", configBuilder.entityDtoPackage + "." + dtoName)
		objectMap.put("entityName", module)
		objectMap.put("entityDtoName", dtoName)
		return objectMap
	}

	/**
	 * 获取路径信息
	 *
	 * @param outputFile 输出文件
	 * @return 路径信息
	 */
	protected String getPathInfo(OutputFile outputFile) {
		return configBuilder.pathInfo.get(outputFile)
	}

	/**
	 * <p>
	 * 将模板转化成为文件
	 * </p>
	 *
	 * @param objectMap    渲染对象 MAP 信息
	 * @param templatePath 模板文件
	 * @param outputFile   文件生成的目录
	 */
	abstract void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception;

	/**
	 * <p>
	 * 处理输出目录
	 * </p>
	 */
	AbstractTemplateEngine mkdirs() {
		println "start mkdirs dirs"
		def controllerDir = configBuilder.controllerPackage.replace(".", "/")
		println "${Paths.get(controllerDir).toFile().getAbsolutePath()}"
		def serviceDir = configBuilder.servicePackage.replace(".", "/")
		return this;
	}

	/**
	 * <p>
	 * 模板真实文件路径
	 * </p>
	 *
	 * @param filePath 文件路径
	 * @return
	 */
	public abstract String templateFilePath(String filePath);
}
