package cn.gyw.glearn.design.behaviour.visitor;

public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject subject) {
		subject.getSubject();
	}
}
