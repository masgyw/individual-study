package cn.gyw.handwritten.gspring.aop.intercept;

import cn.gyw.handwritten.gspring.aop.aspect.GJoinPoint;

import java.lang.reflect.Method;

public interface GMethodInvocation extends GJoinPoint {

    Method getMethod();
}
