package cn.gyw.glearn.designpattern.structural.decorator;

/**
 * 接口的具体实现类
 *
 * Created by guanyw on 2018/7/10.
 */
public class Car implements ICar {
	@Override
	public void move() {
		System.out.println("车移动中...");
	}
}
