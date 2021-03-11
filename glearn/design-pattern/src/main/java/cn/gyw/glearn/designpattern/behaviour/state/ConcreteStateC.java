package cn.gyw.glearn.designpattern.behaviour.state;

public class ConcreteStateC implements State {

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("C 的实现方法");
	}

	@Override
	public void init(Context context) {
		context.setState(this);
	}

}
