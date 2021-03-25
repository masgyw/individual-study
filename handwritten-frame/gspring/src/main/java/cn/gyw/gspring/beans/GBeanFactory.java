package cn.gyw.gspring.beans;

public interface GBeanFactory {

    /**
     * 根据beanName 从IOC容器中获取一个实例bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
