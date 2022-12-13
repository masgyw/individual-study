package cn.gyw.frame.thirdpart.autoservice;

import com.google.auto.service.AutoService;

/**
 * @date 2022/9/1
 */
@AutoService(HelloService.class)
public class LocalHelloService implements HelloService {
    @Override
    public String sayHello() {
        return "local, say hello";
    }
}
