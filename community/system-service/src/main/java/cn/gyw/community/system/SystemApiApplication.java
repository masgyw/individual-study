package cn.gyw.community.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan("cn.gyw.community.system.mapper")
@EnableWebMvc
@EnableEurekaClient
@EntityScan("cn.gyw.platform")
@EnableJpaRepositories("cn.gyw.platform")
@SpringBootApplication(scanBasePackages = { "cn.gyw.platform", "cn.gyw.components", "cn.gyw"},
    exclude = { FreeMarkerAutoConfiguration.class })
public class SystemApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApiApplication.class, args);
    }
}
