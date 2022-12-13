package cn.gyw.middleware.rocketmq.common;

import cn.gyw.middleware.rocketmq.model.MsgConfig;

public enum MsgEnum implements MsgConfig {
    NORMAL("normal-msg-topic", "", "normal-msg-group", "普通消息", Constants.CONSUME_MODE_PUSH),
    ORDER("order-msg-topic", "", "order-msg-group", "顺序消息", Constants.CONSUME_MODE_PUSH),
    DELAY("delay-msg-topic", "", "delay-msg-group", "延迟消息", Constants.CONSUME_MODE_PUSH),

    ;

    private String topic;
    private String tags;
    private String group;
    private String desc;
    private String consumeMode;

    MsgEnum(String topic, String tags, String group, String desc, String consumeMode) {
        this.topic = topic;
        this.tags = tags;
        this.group = group;
        this.desc = desc;
        this.consumeMode = consumeMode;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String getTags() {
        return tags;
    }

    @Override
    public String getGroup() {
        return group;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getConsumeMode() {
        return consumeMode;
    }
}
