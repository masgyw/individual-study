package cn.gyw.glearn.designpattern.creational;

import cn.gyw.glearn.designpattern.creational.singleton.Singleton1;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式的测试
 */
public class SingletonTest {

    /**
     * 单例模式通过反射创建新对象
     */
    @Test
    public void createAnotherSingle1BySetAccessible() {
        Singleton1 singleton1 = Singleton1.getInstance();

        try {
            Class<Singleton1> singleton1Class = Singleton1.class;
            Constructor<Singleton1> constructor = singleton1Class.getConstructor();
            constructor.setAccessible(true);
            Singleton1 another = constructor.newInstance();
            // 引用一致
            Assert.assertFalse(another == singleton1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
