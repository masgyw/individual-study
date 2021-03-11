package cn.gyw.spring;

import cn.gyw.spring.config.ModelConfig;
import cn.gyw.spring.config.RootConfig;
import cn.gyw.spring.model.ModelA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Spring framework
 */
public class SpringApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext apc = new AnnotationConfigApplicationContext(ModelConfig.class);
        // 循环依赖设置
        apc.setAllowCircularReferences(false);

        ModelA modelA = apc.getBean(ModelA.class);

        /*try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
