package cn.gyw.platform.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.gyw.platform.annotations.ThreadSafe;

@ThreadSafe
public final class PropertiesUtil {

	public static Properties readConfig(String configName) {
		ClassLoader classLoader = PropertiesUtil.class.getClassLoader();
		Properties properties = new Properties();
		try (InputStream in = classLoader.getResourceAsStream(configName)) {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
}
