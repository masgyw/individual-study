package cn.gyw.glearn.design.behaviour.visitor;

public interface Subject {

	void accept(Visitor visitor);

	void getSubject();
}
