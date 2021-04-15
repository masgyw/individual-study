# Spring 框架

## 基础
1. Spring5 新特性
- 支持JDK8 ，不再支持旧版本
- 引入响应式变成
- 支持kotlin , WebFlux，去Servlet化
- 基于注解开发，零配置
- SpringMVC 支持Servlet3.0 异步
- Junit5 支持，并发测试
2. Spring有哪些优势，为什么我们要用Spring？
- spring 简化开发
- IOC 容器管理bean的生命周期
- DI 简化依赖管理
- AOP 声明式事务，提出了事务的提前声明
- 模块化：自主选择需要的模块，按需分配
- WebMVC：简化web开发，去Servlet
3. Spring 中用到了哪些设计模式？
- 工厂模式 BeanFactory、ApplicationContext
- 单例模式 默认创建的是单例模式
- 建造者模式 
- 模板方法 AbstractApplicationContext
- AOP 动态代理，AopProxy 实现，JdkProxy，CglibProxy
4. 什么是上下文？
所处的环境，例如tomcat 容器的上下文就是tomcat 环境

## IOC
1. BeanFactory 和 ApplicationContext的区别
- ApplicationContext 是BeanFactory 的子接口
- ApplicationContext 提供了监控功能，bean的生命周期  
PostProcessor 扩展、Aware 回调、Event事件通知等功能
- 支持I18n 国际化
- 扩展了统一资源文件的加载方式  
XMLClassPathApplicationContext/WebXMLApplicationContext/FileSystemApplicationContext/AnnotationApplicationContext等
2. 请解释一下SpringBean 的生命周期  
由spring管理bean 的创建和销毁
- JSR 标准 @PostConstruct 和 @PreDestroy 的支持
- InitializationBean 和 DestroyBean 的回调
- 自定义方法 method-init 和 method destroy 的回调
- Aware 接口  
3. SpringBean的作用域有哪些？有什么区别？SpringBean生命周期特征  
什么是作用域？什么时候创建，什么时候销毁  
Bean 有2中作用域：
- Singleton：单例，容器启动创建，容器停止时销毁
- Prototype：多例，每次调用都会创建一个新对象，用完销毁  
web中新增了3个作用域
- Request：用户请求时创建，响应请求后销毁
- Session：创建会话时创建，会话销毁时对象销毁
- Global-Session：和web容器耦合，web容器创建时创建，web容器销毁时销毁
4. SpringBean 是线程安全的吗？
springBean 是由IOC 容器创建的，BeanDefinition 中保存的是BeanWrapper，实际上对象是通过反射创建的，Bean是否线程安全，和我们写的代码有关，和spring无关，我们写的bean安全就是安全的。
5. Spring 是如何处理循环依赖的？
缓存机制

## DI

## AOP

## MVC

#### 4.1. Spring 事务 @Transactional 事务失效的场景  
1）没有抛出运行时异常，异常被catch，事务不会回滚：TransactionManager 通过catch 运行时异常，判断事务是否需要回滚  
2）this 调用自身方法：事务实际实现是通过动态代理的方式，所以调用的方法是代理类的方法，通过this调用自身的方法，没有走代理类，则不会被事务管理器管理，回滚
