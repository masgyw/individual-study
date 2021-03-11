package cn.gyw.glearn.designpattern.behaviour.command;

/**
 * 命令的封装
 * Created by guanyw on 2018/7/10.
 */
public class ConcretedCommand implements Command {

	private Receiver receiver;

	public ConcretedCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void exec() {
		receiver.action();
	}
}
