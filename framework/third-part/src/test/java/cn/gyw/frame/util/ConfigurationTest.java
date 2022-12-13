package cn.gyw.frame.util;

import cn.gyw.platform.configuration.exception.ConfigurationException;
import cn.gyw.platform.configuration.interfaces.IConfiguration;
import cn.gyw.platform.configuration.service.ConfigurationOnFileINI;
import org.junit.jupiter.api.Test;

/**
 * configuration components test
 */
public class ConfigurationTest {

    @Test
    public void writeConfig() {
        IConfiguration config = new ConfigurationOnFileINI();

        try {
            config.setValue("demo", "1", "2");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

    }


}
