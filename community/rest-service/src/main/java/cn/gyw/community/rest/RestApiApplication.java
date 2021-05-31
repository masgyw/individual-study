package cn.gyw.community.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan(basePackages = {"cn.gyw.community.rest"})
@EnableWebMvc
@EnableEurekaClient
@EnableFeignClients
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = {"cn.gyw.community.rest"},
        exclude = {FreeMarkerAutoConfiguration.class})
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }
}
