 package cn.gyw.glearn.designpattern.behaviour.templatemethod;

public class TemplateMethodMainTest {

	public static void main(String[] args) {
		AbstractTemplate template = new Plus();
		int r = template.calculate("2+10", "\\+");
		System.out.println(r);
	}
}
