# Spring 框架

## 概述
### IOC
refresh()  
1. 定位 getResource
2. 加载 reader.loadBeanDefinitions
3. 注册 BeanDefinitionMap 伪IOC容器
### DI
getBean()  
1. initationBean() 创建BeanWrapper
2. populateBean() 依赖注入，保存到真正的IOC容器中
### AOP
getBean()  
1. AdvisedSupport 加载AOP代理配置
2. 通过解析配置，为每一个方法创建一个MethodInterceptor，构建chain
3. MethodInvocation.proceed() -> MethodInterceptor.invoke() [Before/After/Throwing...]
### MVC
DispatcherServlet.init()
1. initStrategies() 初始化9大组件：initHandleMapping(url->方法的映射)、initHandleAdapter(request请求参数转换为方法可接受的参数)、initViewResover(将方法返回值封装为MV对象)/Videw.render() 往浏览器输出http协议支持的字符串内容

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

### Spring 事务
参考：https://www.cnblogs.com/huangrenhui/p/13261655.html  
1. 理解JDBC API  
DriverManager：解耦不同数据厂商（抽象工厂模式）  
Connection:跟数据库建立联系的一个封装，实际上是Socket TCP  
Statement：语句集，SQL解析器，解析SQL语法  
ResultSet：通过执行SQL获得结果封装，在Java中的体现形式（Map+Cursor）  
2. Spring 事务  
- Spring配置文件中关于事务配置总是由三个组成部分，分别是DataSource、TransactionManager和代理机制这三部分，无论哪种配置方式，一般变化的只是代理机制这部分  
- Spring 把DataSource封装为Session  
- TransactionManager 是一个通知，通过配置切点pointCut，对切入的所有方法进行增强，方法前识入BeforeAdvice开启事务，方法后织入AfterAdvice提交事务，异常时AfterThrowing回滚  
- 为什么JdbcTemplate 操作，会被事务管理？因为DataSource 被事务管理器代理了，拿到的Connection不是JDBC 的原生的Connection，而是加强的DataSource.  
- DataSource、TransactionManager这两部分只是会根据数据访问方式有所变化，比如使用Hibernate进行数据访问时，DataSource实际为SessionFactory，TransactionManager的实现为HibernateTransactionManager；使用JPA进行数据访问时，DataSource实际为EntityManager，TransactionManager的实现为JpaTransactionManager;
3. 编程式事务和声明式事务的优缺点  
编程式事务实现方式：直接使用底层的PlatformTransactionManager、使用TransactionTemplate(Spring)  
声明式事务实现方式：  
- 使用拦截器：基于TransactionInterceptor 类来实施声明式事务管理功能（Spring最初提供的实现方式）；
- Bean和代理：基于 TransactionProxyFactoryBean的声明式事务管理
- 使用tx标签配置的拦截器：基于tx和aop名字空间的xml配置文件（基于Aspectj AOP配置事务）；
- 全注解：基于@Transactional注解；

|item|编程式|声明式|
|---|---|---|
|粒度|代码块|方法|
|侵入性|强|无侵入性|
|代码量|大|代码量小，注解或配置即可|
4. Spring 事务实现方式总结
- 基于 TransactionDefinition、PlatformTransactionManager、TransactionStatus 编程式事务管理是 Spring 提供的最原始的方式，通常我们不会这么写，但是了解这种方式对理解 Spring 事务管理的本质有很大作用。
- 基于 TransactionTemplate 的编程式事务管理是对上一种方式的封装，使得编码更简单、清晰。
- 基于 TransactionInterceptor 的声明式事务是 Spring 声明式事务的基础，通常也不建议使用这种方式，但是与前面一样，了解这种方式对理解 Spring 声明式事务有很大作用。
- 基于 TransactionProxyFactoryBean 的声明式事务是上中方式的改进版本，简化的配置文件的书写，这是 Spring 早期推荐的声明式事务管理方式，但是在 Spring 2.0 中已经不推荐了。
- 基于 <tx> 和 <aop> 命名空间的声明式事务管理是目前推荐的方式，其最大特点是与 Spring AOP 结合紧密，可以充分利用切点表达式的强大支持，使得管理事务更加灵活。
- 基于 @Transactional 的方式将声明式事务管理简化到了极致。开发人员只需在配置文件中加上一行启用相关后处理 Bean 的配置，然后在需要实施事务管理的方法或者类上使用 @Transactional 指定事务规则即可实现事务管理，而且功能也不必其他方式逊色
5. Spring 事务 @Transactional 事务失效的场景  
1）没有抛出运行时异常，异常被catch，事务不会回滚：TransactionManager 通过catch 运行时异常，判断事务是否需要回滚（RuntimeException or Error）,可以指定异常来进行回滚  
2）this 调用自身方法：事务实际实现是通过动态代理的方式，所以调用的方法是代理类的方法，通过this调用自身的方法，没有走代理类，则不会被事务管理器管理，回滚；可以通过AopContext 获取代理对象，实现事务
6. Spring tx 和 aop 命名空间事务的实现原理
7. Spring 事务 @Transactional 的实现原理


## MVC

