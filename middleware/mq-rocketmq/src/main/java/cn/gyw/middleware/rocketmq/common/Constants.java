package cn.gyw.middleware.rocketmq.common;

/**
 * 常量
 *
 * @date 2022/1/30 10:11
 */
public final class Constants {

    // 顺序消息
    public static final String GROUP_PRODUCER_ORDER_MSG = "order-msg-producer-group";
    public static final String GROUP_CONSUMER_ORDER_MSG = "order-msg-consumer-group";
    public static final String TOPIC_ORDER_MSG = "order-msg-topic";

    /** 消息key */
    public static final String KEY_NORMAL_MSG = "normal-msg";
    // 顺序消息
    public static final String KEY_ORDER_MSG = "order-msg";
    // 延迟消息
    public static final String KEY_DELAY_MSG = "delay-msg";

    // 消息模式
    public static final String CONSUME_MSG_CLUSTER = "cluster";
    public static final String CONSUME_MSG_BROADCAST = "broadcast";

    // 消费模式
    public static final String CONSUME_MODE_PUSH = "push";
    public static final String CONSUME_MODE_PULL = "pull";
}
