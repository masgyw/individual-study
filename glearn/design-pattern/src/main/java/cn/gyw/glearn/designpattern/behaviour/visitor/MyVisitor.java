package cn.gyw.glearn.designpattern.behaviour.visitor;

public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject subject) {
		subject.getSubject();
	}
}
