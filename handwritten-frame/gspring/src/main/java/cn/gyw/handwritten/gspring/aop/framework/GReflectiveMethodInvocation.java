package cn.gyw.handwritten.gspring.aop.framework;

import java.lang.reflect.Method;
import java.util.List;

public class GReflectiveMethodInvocation {

	protected GReflectiveMethodInvocation(
			Object proxy, Object target, Method method, Object[] arguments,
			Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {

//		this.proxy = proxy;
//		this.target = target;
//		this.targetClass = targetClass;
//		this.method = BridgeMethodResolver.findBridgedMethod(method);
//		this.arguments = AopProxyUtils.adaptArgumentsIfNecessary(method, arguments);
//		this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
	}
	
	public Object proceed() throws Throwable {
		return null;
	}
}
