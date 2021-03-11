package cn.gyw.glearn.designpattern.behaviour.command;

/**
 * 命令执行者
 *
 * @author guanyw
 */
public class Invoker {

	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	public void invoke() {
		command.exec();
	}

}
