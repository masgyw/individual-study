package cn.gyw.middleware.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NacosApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(NacosApplication.class);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
