package cn.gyw.middleware.nacos.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

/**
 * @author yuewu.guan
 * @desc nacos读取外移配置
 * @createdTime 2022/5/24
 */
public class NacosEnvPostProcessor implements EnvironmentPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(NacosEnvPostProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String configFile = "/data/config-center/bootstrap.properties";
        loadProperty(configFile);

        if ("local".equals(System.getProperty("nacos.config.namespace"))) {
            loadProperty(String.format("%s/config.properties", configFile));
        }
    }

    private void loadProperty(String configFilePath) {
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(new FileSystemResource(configFilePath));
            for (String key : properties.stringPropertyNames()) {
                String value = String.valueOf(properties.get(key));
                log.info("加载配置：{}={}", key, value);
                System.setProperty(key, value);
            }
        } catch (Exception e) {
            log.error("加载配置失败：", e);
        }
    }
}
