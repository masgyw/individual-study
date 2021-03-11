package cn.gyw.platform.mbg.plus;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MbgApplication {
	
	private String configXml = "";
	
	@Test
	public void test() throws Exception {
		ClassLoader classloader = MbgApplication.class.getClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(configXml);

		List<String> warnings = new ArrayList<>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(inputStream);
		
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
		
		generator.generate(null);
		System.out.println(">>>> generate success!");
	}
	
	@Before
	public void init() {
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().contains("windows")) {
			configXml = "generatorConfig-win7.xml";
		} else {
			configXml = "generatorConfig-linux.xml";
		}
	}
}
