package cn.gyw.glearn.designpattern.structural.decorator;

/**
 * 具体装饰器类
 * Created by guanyw on 2018/7/10.
 */
public class FlyCarDecorator extends Decorator {
	public FlyCarDecorator(ICar car) {
		super(car);
	}

	@Override
	public void move() {
		super.move();
		System.out.println("增加飞行功能...");
	}
}
