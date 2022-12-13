package cn.gyw.middleware.rocketmq;

import cn.gyw.middleware.rocketmq.base.MsgProcessorSupport;
import cn.gyw.middleware.rocketmq.base.MsgSender;
import cn.gyw.middleware.rocketmq.common.Constants;
import cn.gyw.middleware.rocketmq.delaymsg.DelayMsgProcessor;
import cn.gyw.middleware.rocketmq.delaymsg.DelayMsgProducer;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import cn.gyw.middleware.rocketmq.model.SimpleMessage;
import cn.gyw.middleware.rocketmq.ordermsg.OrderMsgProducer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 消息测试
 *
 * @date 2022/1/30 10:32
 */
public class RmqMsgTest {

    private static final Logger log = LoggerFactory.getLogger(RmqMsgTest.class);

    private static final Map<String, MsgSender> SENDER_MAP = new HashMap<>();

    public static ExecutorService executor = Executors.newFixedThreadPool(4);

    /**
     * 延迟消息测试
     */
    @Test
    public void delayMsg() {
        List<SimpleMessage> dataList = buildMsg(1L);

        MsgSender msgSender = SENDER_MAP.get(Constants.KEY_DELAY_MSG);
        msgSender.send(dataList.get(0));

        threadWait();
    }

    public List<SimpleMessage> buildMsg(long size) {
        return Stream.iterate(0, i -> i + 1)
                .limit(size)
                .map(i -> {
                    SimpleMessage msgModel = new SimpleMessage();
                    msgModel.setId(i);
                    msgModel.setContent("测试消息" + i);
                    msgModel.setCreatedTime(LocalDateTime.now());
                    return msgModel;
                }).collect(Collectors.toList());
    }

    public void threadWait() {
        try {
            TimeUnit.MINUTES.sleep(3L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUp() {
        // 生产者
        SENDER_MAP.put(Constants.KEY_DELAY_MSG, new DelayMsgProducer());
        SENDER_MAP.put(Constants.KEY_ORDER_MSG, new OrderMsgProducer());
        // 消费者
        MsgProcessorSupport.addProcessor(new DelayMsgProcessor());
    }
}
