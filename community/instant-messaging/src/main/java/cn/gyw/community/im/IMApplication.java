package cn.gyw.community.im;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * war包形式部署：需要继承类 SpringBootServletInitializer
 */

// 组合注解，包括了@SpringBootConfiguration、@EnableAutoConfiguration和@ComponentScan注解
@SpringBootApplication(scanBasePackages = {
        "cn.gyw.community.im", "cn.gyw"})
//@ServletComponentScan // 添加过滤器、拦截器等扫描
//@PropertySource(value = "classpath:my.properties", encoding = "utf-8") // 额外的属性文件
//@SpringBootConfiguration //  @SpringBootConfiguration 继承至@Configuration，对于熟悉spring的开发者而言，此标注当前类是配置类， 并会将当前类内声明的一个或多个以@Bean注解标记的方法的实例纳入到srping容器中，并且实例名就是方法名。
/* 所有符合自动配置条件的bean的定义加载到spring容器中，比如根据spring-boot-starter-web ，来判断你的项目是否需要添加了webmvc和tomcat，
会自动的帮你配置web项目中所需要的默认配置。*/
//@EnableAutoConfiguration
/* 扫描当前包及其子包下被@Component，@Controller，@Service，@Repository等注解标记的类并纳入到spring容器中进行管理。*/
//@ComponentScan
public class IMApplication {

    public static void main(String[] args) {
        SpringApplication.run(IMApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(
            @Value("${server.servlet.context-path}") String contextPath,
            @Value("${server.port}") int port) {
        return args -> System.out.println("http://127.0.0.1:" + port + contextPath);
    }

}
