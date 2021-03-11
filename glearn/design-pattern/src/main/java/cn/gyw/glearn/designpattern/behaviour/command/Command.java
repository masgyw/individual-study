package cn.gyw.glearn.designpattern.behaviour.command;

/**
 * 命令模式
 * 请求者和接收者 解耦
 * 请求者不需要知道谁来执行命令，只是发出不同命令的请求
 * 接受者不用知道谁请求的，只是不同的接受者和不同的命令相关，执行相关的操作
 */
public interface Command {

	void exec();

}
