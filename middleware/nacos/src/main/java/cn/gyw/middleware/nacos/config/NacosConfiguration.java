package cn.gyw.middleware.nacos.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.context.annotation.Configuration;

/**
 * @desc nacos 配置
 * @createdTime 2021/12/22 23:12
 */
@Configuration
// 开启 Nacos Spring 的服务发现功能
@EnableNacosDiscovery(globalProperties = @NacosProperties(serverAddr = "${nacos.config.server-addr}"))
// 配置
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "${nacos.config.server-addr}"))
@NacosPropertySource(dataId = "${nacos.config.data-id}", groupId = "${nacos.config.group}", autoRefreshed = true)
public class NacosConfiguration {


}
