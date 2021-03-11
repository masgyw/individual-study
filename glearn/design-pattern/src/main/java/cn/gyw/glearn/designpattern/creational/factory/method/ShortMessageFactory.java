package cn.gyw.glearn.designpattern.creational.factory.method;

import cn.gyw.glearn.designpattern.creational.entities.Sender;
import cn.gyw.glearn.designpattern.creational.entities.ShortMessageSender;

public class ShortMessageFactory implements Provider {

	@Override
	public Sender produce() {
		return new ShortMessageSender();
	}
}
