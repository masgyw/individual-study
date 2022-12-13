package cn.gyw.middleware.rocketmq.base;

import cn.gyw.middleware.rocketmq.common.AppProperties;
import cn.gyw.middleware.rocketmq.common.Constants;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @author
 * @desc
 * @createdTime 2022/5/24
 */
public final class MsgProcessorSupport {

    /**
     * 创建消费者
     */
    public static void addProcessor(MsgProcessor msgProcessor) {
        MsgConfig msgConfig = msgProcessor.getMsgConfig();
        try {
            if (Constants.CONSUME_MODE_PUSH.equals(msgConfig.getConsumeMode())) {
                newPushConsumer(msgProcessor);
            } else {
                newPullConsumer(msgProcessor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 推模式-消费，broker->应用
     *
     * @param msgProcessor 消息
     * @throws Exception
     */
    private static void newPushConsumer(MsgProcessor msgProcessor) throws Exception {
        MsgConfig msgConfig = msgProcessor.getMsgConfig();

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(msgConfig.getGroup());
        consumer.setNamesrvAddr(AppProperties.getNameserverAddr());
        // 集群消费 同一个groupId下只会又一个应用消费
        if (Constants.CONSUME_MSG_CLUSTER.equals(msgConfig.getMsgMode())) {
            consumer.setMessageModel(MessageModel.CLUSTERING);
        } else {
            // 广播消费
            System.out.println("广播消息消费模式开启");
            consumer.setMessageModel(MessageModel.BROADCASTING);
        }
        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        // 从何处消费
        // CONSUME_FROM_FIRST_OFFSET:第一次启动是从队列头部开始消费
        // CONSUME_FROM_LAST_OFFSET：第一次启动从队列尾部开始消费
        // CONSUME_FROM_TIMESTAMP:
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        // 订阅
        consumer.subscribe(msgConfig.getTopic(), "*");
        // 批量消费消息，默认为1条
        consumer.setConsumeMessageBatchMaxSize(1);
        // 消费线程池
        consumer.setConsumeThreadMin(10);
        consumer.setConsumeThreadMax(20);
        // 批量拉取消息
        // consumer.setPullBatchSize(32);
        // 注册监听类
        consumer.registerMessageListener(msgProcessor);
        // 启动消费者
        consumer.start();
    }

    private static void newPullConsumer(MsgProcessor msgProcessor) throws Exception {
        MsgConfig msgConfig = msgProcessor.getMsgConfig();

        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer(msgConfig.getGroup());
        consumer.setNamesrvAddr(AppProperties.getNameserverAddr());
        /**
         * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
         * 如果非第一次启动，那么按照上次消费的位置继续消费
         */
        // consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // // 订阅
        // consumer.subscribe(getTopicName(), "*");
        // // 批量消费消息，默认为1条
        // consumer.setConsumeMessageBatchMaxSize(1);
        // // 批量拉取消息
        // // consumer.setPullBatchSize(32);
        // // 注册监听类
        // consumer.registerMessageListener(msgProcessor);
        // // 启动消费者
        // consumer.start();
    }

    private MsgProcessorSupport() {
    }

}
