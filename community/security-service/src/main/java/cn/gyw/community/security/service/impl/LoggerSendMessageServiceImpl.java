package cn.gyw.community.security.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.gyw.community.security.service.MessageSendService;

@Service
public class LoggerSendMessageServiceImpl implements MessageSendService {

    private static final Logger logger = LoggerFactory.getLogger(LoggerSendMessageServiceImpl.class);

    @Override
    public void send(String key, String message) {
        logger.info("Send to key:[{}] with message:[{}]", key, message);
    }
}
