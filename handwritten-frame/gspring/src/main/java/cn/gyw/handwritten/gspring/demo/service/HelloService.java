package cn.gyw.handwritten.gspring.demo.service;

import cn.gyw.handwritten.gspring.annotation.GService;

@GService
public class HelloService implements IHelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
