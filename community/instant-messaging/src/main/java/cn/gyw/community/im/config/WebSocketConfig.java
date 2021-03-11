package cn.gyw.community.im.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * SpringBoot + javax.websocket 支持
 *
 * 1. 引入 spring-boot-starter-websocket 包
 * 2. 嵌入式Tomcat 需要 ServerEndpointExporter + @Component 修饰的 @ServerEndpoint 类
 * 3. 非嵌入式Tomcat 不需要 2 步骤，由容器负责
 */
@Configuration
public class WebSocketConfig {

    // 使用嵌入式Tomcat的javax.websocket 必须要注入该bean，否则无法访问
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
