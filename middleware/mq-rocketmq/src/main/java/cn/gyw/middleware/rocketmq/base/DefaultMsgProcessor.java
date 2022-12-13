package cn.gyw.middleware.rocketmq.base;

import cn.gyw.middleware.rocketmq.common.MsgEnum;
import cn.gyw.middleware.rocketmq.model.MqMessageAdapter;
import cn.gyw.middleware.rocketmq.model.MsgConfig;

/**
 * @author
 * @desc
 * @createdTime 2022/5/24
 */
public class DefaultMsgProcessor extends MsgProcessor {

    private MsgConfig msgConfig;

    public DefaultMsgProcessor(MsgConfig msgConfig) {
        this.msgConfig = msgConfig;
    }

    @Override
    protected int processMessage(MqMessageAdapter mqMessageAdapter) throws Exception {
        return 0;
    }

    @Override
    public MsgConfig getMsgConfig() {
        return msgConfig;
    }
}
