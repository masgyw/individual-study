package cn.gyw.glearn.design.behaviour.visitor;

public class MySubject implements Subject {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void getSubject() {
		System.out.println("LOVE....");
	}

}
