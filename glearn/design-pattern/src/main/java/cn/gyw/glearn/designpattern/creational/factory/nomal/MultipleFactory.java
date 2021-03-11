package cn.gyw.glearn.designpattern.creational.factory.nomal;

import cn.gyw.glearn.designpattern.creational.entities.MailSender;
import cn.gyw.glearn.designpattern.creational.entities.Sender;
import cn.gyw.glearn.designpattern.creational.entities.ShortMessageSender;

/**
 * 多个工厂方法模式
 * 违反了OCP原则
 * @author guanyw
 *
 */
public class MultipleFactory {

	public Sender produceMailSender() {
		return new MailSender();
	}

	public Sender produceShortMessageSender() {
		return new ShortMessageSender();
	}
}
