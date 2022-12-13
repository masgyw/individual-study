package cn.gyw.middleware.rocketmq.normalmsg;

import cn.gyw.middleware.rocketmq.base.MsgProcessor;
import cn.gyw.middleware.rocketmq.model.MqMessageAdapter;
import cn.gyw.middleware.rocketmq.model.MsgConfig;

/**
 * @author
 * @desc
 * @createdTime 2022/5/25
 */
public class NormalMsgProcessor extends MsgProcessor {

    private MsgConfig msgConfig;

    public NormalMsgProcessor(MsgConfig msgConfig) {
        this.msgConfig = msgConfig;
    }

    @Override
    protected int processMessage(MqMessageAdapter mqMessage) throws Exception {
        log.info("消费消息topic[{}],消息内容:{}", mqMessage.getTopic(), mqMessage.getMsgBody());
        return 0;
    }

    @Override
    protected MsgConfig getMsgConfig() {
        return msgConfig;
    }
}
