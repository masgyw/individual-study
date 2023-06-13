package cn.gyw.springboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @date 2023/6/13
 */
@Slf4j
public class AopTest {

    @Test
    public void testCustomizableTraceInterceptor() {
        ProxyFactory proxyFactory = new ProxyFactory(new Person());
        proxyFactory.setProxyTargetClass(true);

        CustomizableTraceInterceptor interceptor = new CustomizableTraceInterceptor();

        Advisor advisor = new DefaultPointcutAdvisor(interceptor);
        proxyFactory.addAdvisor(advisor);

        Person person = (Person) proxyFactory.getProxy();

        person.sayHello();
    }
}
