package cn.gyw.platform.mbg.plus;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成
 * 
 * @see https://github.com/abel533/Mapper/wiki/4.2.codegenerator
 */
public class TkMybatisGenerator {

	@Test
	public void commonGenerate() throws Exception {
		ClassLoader classloader = MbgApplication.class.getClassLoader();
		InputStream inputStream = classloader.getResourceAsStream("config-tk-common.xml");

		List<String> warnings = new ArrayList<>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(inputStream);

		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);

		generator.generate(null);
		System.out.println(">>>> generate success!");
	}
}
