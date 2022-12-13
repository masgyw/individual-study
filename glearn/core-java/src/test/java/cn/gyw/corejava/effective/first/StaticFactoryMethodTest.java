package cn.gyw.corejava.effective.first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 静态工厂方法代替默认构造器
 */
public class StaticFactoryMethodTest {

    /**
     * Boolean 类使用了静态工厂方法构造对象Boolean
     */
    @Test
    public void implByBoolean() {
        Boolean flag = Boolean.valueOf(false);
        Assertions.assertEquals(Boolean.FALSE, false);
    }
}
