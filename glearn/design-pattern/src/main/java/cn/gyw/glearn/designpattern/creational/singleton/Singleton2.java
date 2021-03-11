package cn.gyw.glearn.designpattern.creational.singleton;

/**
 * 因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字
 * @author guanyw
 *
 */
public class Singleton2 {

	private static Singleton2 instance = null;

	private Singleton2(){}

	/*
	方法同步，高并发的情况下，效率不高
	 */
	private static synchronized void syncInit() {
		if(instance == null) {
			instance = new Singleton2();
		}
	}

	public static Singleton2 getInstance() {
		if(instance == null) {
			syncInit();
		}
		return instance;
	}
}
