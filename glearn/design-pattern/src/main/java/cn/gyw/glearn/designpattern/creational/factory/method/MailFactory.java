package cn.gyw.glearn.designpattern.creational.factory.method;

import cn.gyw.glearn.designpattern.creational.entities.MailSender;
import cn.gyw.glearn.designpattern.creational.entities.Sender;

public class MailFactory implements Provider {

    @Override
    public Sender produce() {
        return new MailSender();
    }

}
