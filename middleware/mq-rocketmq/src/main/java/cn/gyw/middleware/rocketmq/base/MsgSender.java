package cn.gyw.middleware.rocketmq.base;

import cn.gyw.middleware.rocketmq.model.MsgConfig;
import cn.gyw.middleware.rocketmq.model.SimpleMessage;

/**
 * @author
 * @desc 消息发送
 * @createdTime 2022/5/24
 */
public interface MsgSender {

    void send(SimpleMessage simpleMessage);

    /**
     * 发送消息
     * @param simpleMsg
     */
    void send(final SimpleMessage simpleMsg, final MsgConfig msgConfig);
}
