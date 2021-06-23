package cn.gyw.community.system.config;

import java.util.List;

import cn.gyw.platform.common.web.aop.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	/*
	 * @Bean public ServletRegistrationBean dispatcherRegistration(DispatcherServlet
	 * dispatcherServlet) { ServletRegistrationBean servletRegistrationBean = new
	 * ServletRegistrationBean(dispatcherServlet);
	 * 
	 * return servletRegistrationBean; }
	 */
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthenticationInterceptor())
			.addPathPatterns("/user/**");
		super.addInterceptors(registry);
	}

	/**
	 * 跨域请求 配置拦截器（全局配置）
	 * 
	 * @param registry
	 */
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowCredentials(true).allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
	}

	/**
	 * 配置过滤器 （全局配置）
	 * 
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*");
		config.setAllowCredentials(true);
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");
//        config.addExposedHeader("*");

		UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
		configSource.registerCorsConfiguration("/**", config);
		return new CorsFilter(configSource);
	}
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new MappingJackson2HttpMessageConverter());
    }
}
