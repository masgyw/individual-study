package cn.gyw.handwritten.gspring.context;

import java.util.List;

import cn.gyw.handwritten.gspring.beans.GBeanFactory;
import cn.gyw.handwritten.gspring.beans.factory.config.GBeanDefinition;
import cn.gyw.handwritten.gspring.beans.factory.support.GBeanDefinitionReader;
import cn.gyw.handwritten.gspring.beans.factory.support.GDefaultListableBeanFactory;

/**
 * IOC -> DI -> MVC -> AOP
 *
 */
public class GApplicationContext extends GDefaultListableBeanFactory implements GBeanFactory {
	
	private String[] configLocations;
	
	public GApplicationContext() {
	}
	
	// 参考 ClassPathXmlApplicationContext
	public GApplicationContext(String... configLocations) {
		
	}
	
	@Override
	protected void refresh() {
		// IOC 流程
		// 1. 定位，定位配置文件
		GBeanDefinitionReader reader = new GBeanDefinitionReader();
		
		// 2. 加载配置文件，扫描相关的类，把它们封装为BeanDefinition
		List<GBeanDefinition> beanDefinitions = reader.loadBeanDefinitions(this.configLocations);
		
		// 3. 注册，将配置信息放到容器里面
		doRegisterBeanDefinition(beanDefinitions);
		
		// 4. 把不是延迟加载的类，提前初始化
		doAutowired();
	}
	
    private void doRegisterBeanDefinition(List<GBeanDefinition> beanDefinitions) {
    	GBeanDefinition beanDefinition;
    	for (int i = 0 , len = beanDefinitions.size() ; i < len ; i ++) {
    		beanDefinition = beanDefinitions.get(i);
    		super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), value)
    	}
	}

	@Override
    public Object getBean(String beanName) {
        return null;
    }
}
