package cn.gyw.community.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableWebMvc
@EnableEurekaClient
@EntityScan("cn.gyw.platform")
@EnableJpaRepositories("cn.gyw.platform")
@SpringBootApplication(scanBasePackages = {"cn.gyw.community", "cn.gyw.platform"}, exclude = {FreeMarkerAutoConfiguration.class})
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
