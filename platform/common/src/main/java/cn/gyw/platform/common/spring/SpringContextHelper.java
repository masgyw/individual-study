package cn.gyw.platform.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * @desc Spring 上下文帮助类
 * 注意：使用时，需要手动通过@Bean注入到上下文中
 * @createdTime 2022/2/12 13:51
 */
public final class SpringContextHelper implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * 获取bean
     *
     * @param clazz 类名
     * @return 泛型类
     */
    public static <T> T popBean(Class<T> clazz) {
        if (context == null) {
            return null;
        }
        return context.getBean(clazz);
    }

    /**
     * 获取bean
     *
     * @param name  bean名称
     * @param clazz bean类名
     * @return 泛型类
     */
    public static <T> T popBean(String name, Class<T> clazz) {
        if (context == null) {
            return null;
        }
        return context.getBean(name, clazz);
    }

    /**
     * 发布事件
     *
     * @param event 事件
     */
    public static void publish(ApplicationEvent event) {
        context.publishEvent(event);
    }

    /**
     * 获取Spring上下文
     *
     * @return context
     */
    public static ApplicationContext getContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHelper.context = applicationContext;
    }
}
