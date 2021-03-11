package cn.gyw.glearn.designpattern.behaviour.command;

/**
 * 实际 命令的执行者
 */
public class Receiver {

	private String name;

	public void action() {
		System.out.println(name + "收到执行指令，正在处理。。。。");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
