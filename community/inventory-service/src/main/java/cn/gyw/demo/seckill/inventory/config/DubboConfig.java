package cn.gyw.demo.seckill.inventory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
@DependsOn("rootConfig")
public class DubboConfig {

	@Value("${dubbo.name}")
	private String dubboName;
	@Value("${dubbo.address}")
	private String address;
	@Value("${dubbo.client}")
	private String client;
	@Value("${dubbo.protocolName}")
	private String protocolName;
	@Value("${dubbo.protocolPort}")
	private Integer protocolPort;
	@Value("${dubbo.cacheFile}")
	private String cacheFile;
	
	/**
     * 应用名配置，等同于 <dubbo:application name="xxx"  />
     *
     * @return ApplicationConfig
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboName);
        return applicationConfig;
    }

    /**
     * 注册中心配置，等同于 <dubbo:registry address="url" />
     *
     * @return RegistryConfig
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(address);
        registryConfig.setClient(client);
        registryConfig.setFile(cacheFile);
        return registryConfig;
    }

    /**
     * 协议配置，等同于 <dubbo:protocol name="dubbo" port="20880" />
     *
     * @return ProtocolConfig
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolName);
        protocolConfig.setPort(protocolPort);
        return protocolConfig;
    }
    
    /**
     * 消费者配置不主动监督zookeeper服务
     *
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig() {
       ConsumerConfig consumerConfig = new ConsumerConfig();
       consumerConfig.setCheck(false);
       consumerConfig.setTimeout(20000);
       return consumerConfig;
    }
}
