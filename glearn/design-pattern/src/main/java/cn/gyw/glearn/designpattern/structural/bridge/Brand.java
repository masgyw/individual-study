package cn.gyw.glearn.designpattern.structural.bridge;

/**
 * 品牌维度 抽象接口
 * Created by guanyw on 2018/7/10.
 */
public interface Brand {
	void sale();
}

class Lenovo implements Brand {
	@Override
	public void sale() {
		System.out.println("联想");
	}
}

class Dell implements Brand {
	@Override
	public void sale() {
		System.out.println("戴尔");
	}
}
