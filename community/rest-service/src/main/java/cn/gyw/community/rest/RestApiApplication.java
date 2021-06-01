package cn.gyw.community.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import tk.mybatis.spring.annotation.MapperScan;

// TkMybatis 的 注解
@MapperScan(basePackages = {"cn.gyw.community.rest.mapper"})
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
