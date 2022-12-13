package cn.gyw.middleware.rocketmq;

import cn.gyw.middleware.rocketmq.base.MsgProcessor;
import cn.gyw.middleware.rocketmq.base.MsgProcessorSupport;
import cn.gyw.middleware.rocketmq.common.Constants;
import cn.gyw.middleware.rocketmq.common.MsgEnum;
import cn.gyw.middleware.rocketmq.delaymsg.DelayMsgProcessor;
import cn.gyw.middleware.rocketmq.model.DefaultConfig;
import cn.gyw.middleware.rocketmq.model.MsgConfig;
import cn.gyw.middleware.rocketmq.normalmsg.NormalMsgProcessor;

import java.io.IOException;

/**
 * @author
 * @desc
 * @createdTime 2022/5/24
 */
public class ConsumerMain {

    public static void main(String[] args) throws Exception {
        // 消费者
        DefaultConfig msgConfig = new DefaultConfig();
        msgConfig.copy(MsgEnum.NORMAL);
        // msgConfig.setMsgMode(Constants.CONSUME_MSG_CLUSTER);
        msgConfig.setMsgMode(Constants.CONSUME_MSG_BROADCAST);

        MsgProcessorSupport.addProcessor(new NormalMsgProcessor(msgConfig));

        // MsgProcessorSupport.addProcessor(new DelayMsgProcessor());


        System.in.read();
    }
}
