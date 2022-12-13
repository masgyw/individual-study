package cn.gyw.springboot;

import cn.gyw.springboot.profiles.ProfileProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"cn.gyw.springboot"},
        exclude = {RedisAutoConfiguration.class, FreeMarkerAutoConfiguration.class})
public class BootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(BootApplication.class)
                .bannerMode(Banner.Mode.OFF)
//        	.logStartupInfo(false)
                .build().run(args);

        ProfileProperties profileProperties = context.getBean(ProfileProperties.class);
        System.out.println("server.host.name:" + profileProperties.getServerHost());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(BootApplication.class);
        SpringApplication springApplication = builder.application();
        springApplication.setAllowBeanDefinitionOverriding(true);
        springApplication.setBannerMode(Banner.Mode.OFF);
        return builder;
    }
}
