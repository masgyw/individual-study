package cn.gyw.middleware.rocketmq.delaymsg;

import cn.gyw.middleware.rocketmq.base.MsgProcessor;
import cn.gyw.middleware.rocketmq.common.MsgEnum;
import cn.gyw.middleware.rocketmq.model.MqMessageAdapter;
import cn.gyw.middleware.rocketmq.model.MsgConfig;

/**
 * 延迟消息消费者
 *
 * @author yuewu.guan
 * @date 2022/1/30 10:14
 */
public class DelayMsgProcessor extends MsgProcessor {

    @Override
    public int processMessage(MqMessageAdapter mqMessage) {
        log.info("消费消息topic[{}],消息内容:{}", mqMessage.getTopic(), mqMessage.getMsgBody());
        return 0;
    }

    @Override
    protected MsgConfig getMsgConfig() {
        return MsgEnum.DELAY;
    }
}
