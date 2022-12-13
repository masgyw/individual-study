package cn.gyw.middleware.rocketmq.model;

import com.alibaba.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;

/**
 * RocketMQ message适配器
 *
 * @date 2022/1/30 10:53
 */
public class MqMessageAdapter {

    private MessageExt messageExt;

    public MqMessageAdapter(MessageExt messageExt) {
        this.messageExt = messageExt;
    }

    public String getTopic() {
        return messageExt.getTopic();
    }

    public String getTags() {
        return messageExt.getTags();
    }

    public String getMsgBody() {
        return new String(messageExt.getBody(), StandardCharsets.UTF_8);
    }

    /**
     * 获取重试次数
     *
     * @return
     */
    public int getReconsumeTimes() {
        return messageExt.getReconsumeTimes();
    }
}
