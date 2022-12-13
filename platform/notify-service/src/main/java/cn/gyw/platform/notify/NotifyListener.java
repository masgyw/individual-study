package cn.gyw.platform.notify;

import cn.gyw.platform.notify.model.NotifyEvent;
import cn.gyw.platform.notify.service.NotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @desc 监控事件监听器
 * @createdTime 2022/2/1 12:47
 */
@Component
public class NotifyListener implements ApplicationListener<NotifyEvent> {

    private static final Logger log = LoggerFactory.getLogger(NotifyListener.class);

    @Resource(name = "serverJService")
    private NotifyService notifyService;

    @Override
    public void onApplicationEvent(NotifyEvent event) {
        log.info("收到事件：{}", event);
        boolean ret = notifyService.sendNotify(event.getMsgTitle(), event.getMsgContent());
        log.info("消息通知结果：{}", ret ? "成功" : "失败");
    }
}
