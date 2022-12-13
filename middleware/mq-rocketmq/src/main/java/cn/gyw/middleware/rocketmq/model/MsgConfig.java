package cn.gyw.middleware.rocketmq.model;

import cn.gyw.middleware.rocketmq.common.Constants;

/**
 * @author
 * @desc rocketmq消息配置
 * @createdTime 2022/5/24
 */
public interface MsgConfig {

    String getTopic();

    default String getTags() {
        return "";
    }

    String getGroup();

    String getDesc();

    default String getMsgMode() {
        return Constants.CONSUME_MSG_CLUSTER;
    }

    default String getConsumeMode() {
        return Constants.CONSUME_MODE_PUSH;
    }

    default Integer getDelayTimeLevel() {
        return 0;
    }
}
