package cn.gyw.glearn.designpattern.behaviour.visitor;

public interface Subject {

	void accept(Visitor visitor);

	void getSubject();
}
