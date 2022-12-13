package cn.gyw.middleware.rocketmq.base;

import cn.gyw.middleware.rocketmq.common.AppProperties;
import cn.gyw.middleware.rocketmq.common.MsgEnum;
import cn.gyw.middleware.rocketmq.model.MqMessageAdapter;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.MQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author
 * @desc
 * @createdTime 2022/5/24
 */
public abstract class MsgProcessor implements MessageListenerConcurrently {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                    ConsumeConcurrentlyContext context) {
        log.info("消费消息数量：{}", list.size());
        int failedCount = 0;
        try {
            for (MessageExt msg : list) {
                failedCount += processMessage(new MqMessageAdapter(msg));
            }
        } catch (Exception e) {
            throw new RuntimeException("消息消费处理异常");
        }

        if (failedCount == 0) {
            // 发送成功
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        // 异常重试
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }

    protected abstract int processMessage(MqMessageAdapter mqMessageAdapter) throws Exception;

    protected abstract MsgConfig getMsgConfig();
}
