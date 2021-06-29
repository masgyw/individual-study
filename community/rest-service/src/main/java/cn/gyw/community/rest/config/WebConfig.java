package cn.gyw.community.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	/**
	 * 解决bug：通过RestResponseAdvice 封装返回结果，原始数据为String类型时，异常：java.lang.ClassCastException
	 * 原因：因为在所有的 HttpMessageConverter 实例集合中，StringHttpMessageConverter 要比其它的 Converter 排得靠前一些。
	 * 我们需要将处理 Object 类型的 HttpMessageConverter 放得靠前一些。
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0, new MappingJackson2HttpMessageConverter());
	}
	
}
