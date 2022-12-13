package cn.gyw.middleware.rocketmq.ordermsg;

import cn.gyw.middleware.rocketmq.base.AbstractProducer;
import cn.gyw.middleware.rocketmq.common.MsgEnum;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import cn.gyw.middleware.rocketmq.model.SimpleMessage;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;

import java.util.List;


/**
 * Producer，发送顺序消息
 */
public class OrderMsgProducer extends AbstractProducer<SimpleMessage> {

    @Override
    public void send(SimpleMessage simpleMessage) {
        this.send(simpleMessage, getMsgConfig());
    }

    @Override
    public void send(SimpleMessage simpleMsg, MsgConfig msgConfig) {
        String[] tags = new String[]{"TagA", "TagB", "TagC", "TagD", "TagE"};
        // 相同余数进入同一订单
        int seq = simpleMsg.getId() % 10;
        String tag = tags[simpleMsg.getId() % tags.length];
        String key = "KEY_" + simpleMsg.getId();
        // msgKey??
        Message msg = new Message(msgConfig.getTopic(), tag, key, getMsgContent(simpleMsg));

        // MessageQueueSelector 队列选择器：
        try {
            SendResult sendResult = mqProducer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, seq);
            log.info("消息发送结果：{}", sendResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected MsgConfig getMsgConfig() {
        return MsgEnum.ORDER;
    }
}
