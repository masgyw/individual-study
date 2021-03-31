package cn.gyw.gspring.beans.support;

import cn.gyw.gspring.beans.config.GBeanDefinition;
import cn.gyw.gspring.context.support.GAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GDefaultListableBeanFactory extends GAbstractApplicationContext {

    // 注册信息BeanDefinition 存储
    private final Map<String, GBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
}
