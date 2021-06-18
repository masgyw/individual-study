package cn.gyw.platform.plugin.mbg.engine

import java.nio.charset.Charset

import cn.gyw.platform.plugin.mbg.config.ConfigBuilder
import freemarker.template.Configuration
import freemarker.template.Template

class FreemarkerTemplateEngine extends AbstractTemplateEngine {

	Configuration configuration
	
	public FreemarkerTemplateEngine init(ConfigBuilder configBuilder) {
		super.init(configBuilder)
		configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		configuration.setDefaultEncoding(Charset.forName("UTF-8").name)
		configuration.setClassForTemplateLoading(FreemarkerTemplateEngine.class, "")
		return this
	}
	
	@Override
	public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws Exception {
		Template template = configuration.getTemplate(templatePath)
        FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFile))
        template.process(objectMap, new OutputStreamWriter(fileOutputStream, ConstVal.UTF8))
        fileOutputStream.close();
        println ("模板:" + templatePath + ";  文件:" + outputFile)
	}
	
	@Override
	public String templateFilePath(String filePath) {
		StringBuilder fp = new StringBuilder();
		fp.append(filePath).append(".ftl");
		return fp.toString();
	}
}
