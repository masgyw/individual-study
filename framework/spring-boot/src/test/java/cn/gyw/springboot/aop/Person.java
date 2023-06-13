package cn.gyw.springboot.aop;

import java.time.LocalDateTime;

/**
 * @date 2023/6/13
 */
public class Person {

    public String sayHello() {
        System.out.println("sayHello() = " + LocalDateTime.now());
        return "hello";
    }
}
