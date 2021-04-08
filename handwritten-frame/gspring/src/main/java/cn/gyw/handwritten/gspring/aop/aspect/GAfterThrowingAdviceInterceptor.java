package cn.gyw.handwritten.gspring.aop.aspect;

import cn.gyw.handwritten.gspring.aop.intercept.GMethodInterceptor;
import cn.gyw.handwritten.gspring.aop.intercept.GMethodInvocation;

import java.lang.reflect.Method;

public class GAfterThrowingAdviceInterceptor extends GAbstractAspectAdvice implements GMethodInterceptor {

    private String throwName;

    public GAfterThrowingAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(GMethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        } catch (Throwable e) {
            invokeAdviceMethod(mi, null, e.getCause());
            throw e;
        }
    }

    public void setThrowName(String throwName) {
        this.throwName = throwName;
    }
}
