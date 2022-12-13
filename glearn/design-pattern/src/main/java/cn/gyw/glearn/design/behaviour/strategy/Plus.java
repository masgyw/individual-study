package cn.gyw.glearn.design.behaviour.strategy;

public class Plus extends AbstractCalculate {

	@Override
	public int calculate(String exp) {
		int[] params = this.split(exp, "\\+");
		return params[0] + params[1];
	}

}
