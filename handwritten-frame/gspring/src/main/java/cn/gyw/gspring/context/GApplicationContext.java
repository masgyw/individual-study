package cn.gyw.gspring.context;

import cn.gyw.gspring.beans.GBeanFactory;
import cn.gyw.gspring.beans.support.GDefaultListableBeanFactory;

public class GApplicationContext extends GDefaultListableBeanFactory implements GBeanFactory {
    @Override
    public Object getBean(String beanName) {
        return null;
    }
}
