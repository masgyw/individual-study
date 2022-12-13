package cn.gyw.middleware.rocketmq.model;

import cn.gyw.middleware.rocketmq.common.MsgEnum;

/**
 * @createdTime 2022/5/24
 */
public class DefaultConfig implements MsgConfig {

    private String topic;
    private String group;
    private String desc;
    /**
     * 消息模式
     * cluster:集群消息
     * broadcast:广播消息
     */
    private String msgMode;

    public DefaultConfig() {
    }

    public DefaultConfig(String topic, String group, String desc) {
        this.topic = topic;
        this.group = group;
        this.desc = desc;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setMsgMode(String msgMode) {
        this.msgMode = msgMode;
    }

    @Override
    public String getTopic() {
        return topic;
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
    public String getMsgMode() {
        return msgMode;
    }

    public void copy(MsgEnum normal) {
        setTopic(normal.getTopic());
        setGroup(normal.getGroup());
        setDesc(normal.getDesc());
    }
}
