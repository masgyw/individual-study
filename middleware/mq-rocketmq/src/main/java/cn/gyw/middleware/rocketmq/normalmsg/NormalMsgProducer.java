package cn.gyw.middleware.rocketmq.normalmsg;

import cn.gyw.middleware.rocketmq.base.AbstractProducer;
import cn.gyw.middleware.rocketmq.common.MsgEnum;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import cn.gyw.middleware.rocketmq.model.SimpleMessage;
import com.alibaba.rocketmq.common.message.Message;

/**
 * @author
 * @desc 普通消息生产者
 * @createdTime 2022/5/25
 */
public class NormalMsgProducer extends AbstractProducer<SimpleMessage> {

    @Override
    protected MsgConfig getMsgConfig() {
        return MsgEnum.NORMAL;
    }

    @Override
    public void send(SimpleMessage simpleMessage) {
        this.send(simpleMessage, getMsgConfig());
    }

    @Override
    public void send(SimpleMessage simpleMsg, MsgConfig msgConfig) {
        Message message = new Message(msgConfig.getTopic(), "", getMsgContent(simpleMsg));
        // 同步消息
        try {
            mqProducer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
