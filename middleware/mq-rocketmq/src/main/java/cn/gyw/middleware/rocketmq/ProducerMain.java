package cn.gyw.middleware.rocketmq;

import cn.gyw.middleware.rocketmq.base.MsgSender;
import cn.gyw.middleware.rocketmq.common.Constants;
import cn.gyw.middleware.rocketmq.delaymsg.DelayMsgProducer;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import cn.gyw.middleware.rocketmq.model.SimpleMessage;
import cn.gyw.middleware.rocketmq.normalmsg.NormalMsgProducer;
import cn.gyw.middleware.rocketmq.ordermsg.OrderMsgProducer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author
 * @desc
 * @createdTime 2022/5/24
 */
public class ProducerMain {

    private static final Map<String, MsgSender> SENDER_MAP = new HashMap<>();

    public static void main(String[] args) {
        // 生产者
        SENDER_MAP.put(Constants.KEY_NORMAL_MSG, new NormalMsgProducer());
        SENDER_MAP.put(Constants.KEY_DELAY_MSG, new DelayMsgProducer());
        SENDER_MAP.put(Constants.KEY_ORDER_MSG, new OrderMsgProducer());

        List<SimpleMessage> dataList = buildMsg(10L);
        MsgSender msgSender = null;
        msgSender = SENDER_MAP.get(Constants.KEY_NORMAL_MSG);
        // msgSender = SENDER_MAP.get(Constants.KEY_DELAY_MSG);
        for (SimpleMessage msg : dataList) {
            msgSender.send(msg);
        }
    }

    public static List<SimpleMessage> buildMsg(long size) {
        return Stream.iterate(0, i -> i + 1)
                .limit(size)
                .map(i -> {
                    SimpleMessage msgModel = new SimpleMessage();
                    msgModel.setId(i);
                    msgModel.setContent("测试消息" + i + ","
                            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
                    msgModel.setCreatedTime(LocalDateTime.now());
                    return msgModel;
                }).collect(Collectors.toList());
    }
}
