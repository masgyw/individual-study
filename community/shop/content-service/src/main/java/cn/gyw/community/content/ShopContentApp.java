package cn.gyw.community.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = {"cn.gyw.community", "cn.gyw.platform"})
public class ShopContentApp {

    public static void main(String[] args) {
        SpringApplication.run(ShopContentApp.class, args);
    }
}
