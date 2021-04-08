package cn.gyw.handwritten.gspring.aop.intercept;

public interface GMethodInterceptor {

    Object invoke(GMethodInvocation invocation) throws Throwable;

}
