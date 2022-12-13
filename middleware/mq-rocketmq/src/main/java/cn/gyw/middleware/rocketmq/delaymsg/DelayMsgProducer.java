package cn.gyw.middleware.rocketmq.delaymsg;

import cn.gyw.middleware.rocketmq.base.AbstractProducer;
import cn.gyw.middleware.rocketmq.common.MsgEnum;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import cn.gyw.middleware.rocketmq.model.SimpleMessage;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 延迟消息生产者
 *
 * @author yuewu.guan
 * @date 2022/1/30 9:23
 */
public class DelayMsgProducer extends AbstractProducer<SimpleMessage> {

    @Override
    public void send(SimpleMessage simpleMessage) {
        MsgConfig msgConfig = getMsgConfig();
        this.send(simpleMessage, msgConfig);
    }

    /**
     * 下面这段代码表明一个Producer对象可以发送多个topic，多个tag的消息。
     * 注意：send方法是同步调用，只要不抛异常就标识成功。但是发送成功也可会有多种状态，<br>
     * 例如消息写入Master成功，但是Slave不成功，这种情况消息属于成功，但是对于个别应用如果对消息可靠性要求极高，<br>
     * 需要对这种情况做处理。另外，消息可能会存在发送失败的情况，失败重试由应用来处理。
     */
    @Override
    public void send(SimpleMessage simpleMsg, MsgConfig msgConfig) {
        Message message = new Message(msgConfig.getTopic(), "", getMsgContent(simpleMsg));

        if (Objects.nonNull(msgConfig.getDelayTimeLevel())) {
            message.setDelayTimeLevel(msgConfig.getDelayTimeLevel());
        }
        try {
            log.info("延迟消息topic={},发送时间：{}", msgConfig.getTopic(), LocalDateTime.now());
            mqProducer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("发送结果：{}", sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("发送失败：" + throwable.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected MsgConfig getMsgConfig() {
        return MsgEnum.DELAY;
    }
}
