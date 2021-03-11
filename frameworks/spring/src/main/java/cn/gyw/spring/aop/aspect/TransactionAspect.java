package cn.gyw.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * 测试事务切面
 */
@Aspect
@Order(2)
public class TransactionAspect {

    @Pointcut(value = "(execution(* cn.gyw.spring.service.*Service.*(..)))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(){
        System.out.println("Transaction before");
    }
}
