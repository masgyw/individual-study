package cn.gyw.middleware.rocketmq.common;

import cn.gyw.platform.configuration.interfaces.IConfiguration;
import cn.gyw.platform.configuration.service.ConfigurationOnFileYaml;

/**
 * 应用配置
 *
 * @author yuewu.guan
 * @date 2022/1/30 10:17
 */
public final class AppProperties {

    private static final IConfiguration CONFIG = new ConfigurationOnFileYaml();

    /**
     * 获取命名服务地址
     */
    public static String getNameserverAddr() {
        return CONFIG.getValue("rocketmq", "nameserver.addr");
    }

    private AppProperties() {
    }
}
