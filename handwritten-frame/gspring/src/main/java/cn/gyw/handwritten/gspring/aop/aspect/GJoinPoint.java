package cn.gyw.handwritten.gspring.aop.aspect;

public interface GJoinPoint extends GAdvice {

    Object proceed() throws Throwable;

    Object getThis();

    Object[] getArguments();
}
