package cn.gyw.corejava.concurrent;

/**
 * 维护线程限制
 *
 * get 访问器 总是返回由当前执行线程通过set设置的最新值
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> strLocal = new ThreadLocal<>();
    
    public static void main(String[] args) {
		
    	new Thread(new Runnable() {
			
			@Override
			public void run() {
				strLocal.set("123");
			}
		}).start();
    	
    	
	}
}
