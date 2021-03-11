package cn.gyw.components.web.log.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.gyw.components.web.log.entity.ApiLog;
import cn.gyw.components.web.log.event.ApiLogEvent;
import cn.gyw.components.web.log.service.ApiLogShardingService;

/**
 * api log event 监听器
 */
@Component
public class ApiLogEventListener implements ApplicationListener<ApiLogEvent> {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiLogEventListener.class);

    @Autowired
    private ApiLogShardingService apiLogService;

    @Override
    public void onApplicationEvent(ApiLogEvent event) {
        Object source = event.getSource();
        LOGGER.debug("reveive source :[{}]", source);
        if (source instanceof ApiLog) {
            ApiLog apiLog = (ApiLog) source;
            apiLogService.save(apiLog);
        }
    }
}
