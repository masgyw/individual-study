package cn.gyw.platform.plugin.mbg.engine

import cn.gyw.platform.plugin.mbg.config.ConfigBuilder

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
		return this;
	}
	
	/**
	 * 生成文件
	 */
	void batchOutput() {
		for (String module : moduleList) {
			Map<String, Object> objectMap = new HashMap<>(16);
			objectMap.put("restControllerStyle", configBuilder.restControllerStyle)
			objectMap.put("controllerPackage", configBuilder.controllerPackage)
			objectMap.put("superControllerClassPackage", configBuilder.superControllerClassPackage)
			objectMap.put("moduleName", configBuilder.moduleName)
			objectMap.put("controllerName", configBuilder.controllerName)
			
		}		
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
	public AbstractTemplateEngine mkdirs() {
		getConfigBuilder().pathInfo.each {key, value ->
			File dir = new File(value);
			if (!dir.exists()) {
				boolean result = dir.mkdirs();
				if (result) {
					println ("创建目录： [" + value + "]");
				}
			}
		}
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
