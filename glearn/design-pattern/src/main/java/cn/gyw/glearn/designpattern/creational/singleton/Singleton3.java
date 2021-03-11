package cn.gyw.glearn.designpattern.creational.singleton;

/**
 * 枚举实现单例模式
 * Created by guanyw on 2018/7/9.
 */
public enum Singleton3 {

	/**
	 * 定义一个枚举元素，本身就是一个单例的实例了
	 */
	INSTANCE;

	public void singletonOperate() {
		System.out.println("invoke");
	}

}
