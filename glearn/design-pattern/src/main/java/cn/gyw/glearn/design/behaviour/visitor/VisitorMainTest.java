package cn.gyw.glearn.design.behaviour.visitor;

/**
 * 访问者模式
 * 数据结构和其行为解耦
 * 在现有结构不变的情况下，增加新功能
 *
 * 访问者和访问对象互相持有对象
 * @author guanyw
 *
 */
public class VisitorMainTest {
	public static void main(String[] args) {
		Visitor visitor = new MyVisitor();
		Subject sub = new MySubject(); // 原有对象，原数据结构
		sub.accept(visitor);

//		visitor.visit(sub);
	}
}
