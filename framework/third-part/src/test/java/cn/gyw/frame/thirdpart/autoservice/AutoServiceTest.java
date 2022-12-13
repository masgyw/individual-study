package cn.gyw.frame.thirdpart.autoservice;

import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

/**
 * 注解处理器
 *
 * @date 2022/9/1
 */
public class AutoServiceTest {

    @Test
    public void autoService() {
        ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);
        for (HelloService userService : serviceLoader) {
            System.out.println(userService.sayHello());
        }
    }
}
