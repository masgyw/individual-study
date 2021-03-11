package cn.gyw.glearn.designpattern.creational.entities;

public class ShortMessageSender implements Sender {

	@Override
	public void send() {
		System.out.println("Short message send ....");
	}

}
