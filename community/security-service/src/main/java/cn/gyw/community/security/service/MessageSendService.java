package cn.gyw.community.security.service;

/**
 * 消息发送服务
 */
public interface MessageSendService {

	void send(String key, String message);
}
