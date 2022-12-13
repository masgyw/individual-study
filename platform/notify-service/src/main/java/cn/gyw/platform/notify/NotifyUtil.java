package cn.gyw.platform.notify;

import cn.gyw.platform.common.spring.SpringContextHelper;
import cn.gyw.platform.notify.model.NotifyEvent;
import cn.gyw.platform.notify.model.SimpleMessage;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @desc 通知工具
 * @createdTime 2022/2/12 13:39
 */
public final class NotifyUtil {

    private static final Logger log = LoggerFactory.getLogger(NotifyUtil.class);

    /**
     * 通知
     */
    public static <T extends SimpleMessage> void notify(Class<?> source, String title, T content) {
        if (Objects.isNull(content)) {
            log.error("消息内容为空，不通知");
            return;
        }
        NotifyEvent notifyEvent = new NotifyEvent(source.getName());
        notifyEvent.setMsgTitle(title);
        notifyEvent.setMsgContent(new Gson().toJson(content));
        SpringContextHelper.publish(notifyEvent);
    }

    private NotifyUtil() {
    }
}
