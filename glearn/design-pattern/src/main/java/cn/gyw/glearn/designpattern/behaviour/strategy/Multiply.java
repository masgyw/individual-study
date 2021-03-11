package cn.gyw.glearn.designpattern.behaviour.strategy;

public class Multiply extends AbstractCalculate {

	@Override
	public int calculate(String exp) {
		int[] params = this.split(exp, "\\*");
		return params[0] * params[1];
	}

}
