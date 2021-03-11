package cn.gyw.community.product;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner, ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Arrays.asList(applicationContext.getBeanDefinitionNames()).forEach(beanName -> {
//			System.out.println(">>" + beanName);
		});
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
