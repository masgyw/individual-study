package cn.gyw.springboot.config;

import cn.gyw.springboot.intercept.LogInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

// @EnableWebMvc
@Configuration
@ComponentScan(basePackages = "cn.gyw.springboot.webmvc")
public class WebConfig implements WebMvcConfigurer {

    /**
     * 添加类型转换器和格式化器
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(LocalDate.class, new Formatter<Object>() {
            @Override
            public String print(Object o, Locale locale) {
                return null;
            }

            @Override
            public Object parse(String s, Locale locale) throws ParseException {
                return null;
            }
        });
    }

    /**
     * 配置请求视图映射
     */
    @Bean
    public ViewResolver defaultViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //请求视图文件的前缀地址
        viewResolver.setPrefix("/views/");
        //请求视图文件的后缀
        viewResolver.setSuffix(".jsp");
        viewResolver.setCache(false);
        return viewResolver;
    }

    /**
     * 视图配置
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.viewResolver(defaultViewResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("hello.htm");
    }

    /**
     * 内容协商配置
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        /* 是否通过请求Url的扩展名来决定media type */
        configurer.favorPathExtension(true)
                /* 不检查Accept请求头 */
                .ignoreAcceptHeader(true)
                .parameterName("mediaType")
                /* 设置默认的media_type */
                .defaultContentType(MediaType.APPLICATION_JSON_UTF8)
                /* 请求以.html结尾的会被当成MediaType.TEXT_HTML*/
                .mediaType("html", MediaType.TEXT_HTML)
                /* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON*/
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    /**
     * Spring Boot<=1.3 无需定义，Spring Boot自动定义
     * Spring Boot >= 1.4 Spring Boot不再自动定义一个RestTemplate，手动通过builder生成
     *
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/jsp/*")
                // swagger 相关接口
                .excludePathPatterns("/swagger*/**", "/webjars/**", "/v2/**");
    }

    /**
     * 异步支持
     *
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // tomcat默认10秒
        configurer.setDefaultTimeout(30 * 1000L);
        // 借助的TaskExecutor
        configurer.setTaskExecutor(createTaskExecutor());
    }

    // 线程池
    private ThreadPoolTaskExecutor createTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.setKeepAliveSeconds(120);
        return taskExecutor;
    }

    /**
     * 配置静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源
        registry.addResourceHandler("hello.htm")
                .addResourceLocations("/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        // 解决Swagger-ui不显示的问题
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/views/**")
                .addResourceLocations("/views/");
    }
}
