package cn.gyw.glearn.designpattern.creational.singleton;

/**
 * 饿汉式单例：当类一加载就直接new一个静态实例。
 * Created by guanyw on 2018/7/9.
 */
public class Singleton1 {

	/*
	私有化构造函数
	 */
	private Singleton1() {}

	/*
	静态变量
	类一加载，就new一个实例出来，从属这个类
	PS:享有特权的客户端可以借助AccessibleObject.setAccessible方法，通过反射机制调用私有构造器，
	抵御这种攻击可以修改构造器，在第二次创建时抛出异常。
	 */
	private static final Singleton1 singleton = new Singleton1();

	/*
	共有 静态方法获取单例
	 */
	public static Singleton1 getInstance() {
		return singleton;
	}

}
