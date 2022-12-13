package cn.gyw.platform.notify.model;

import java.io.Serializable;

/**
 * @desc 简单通知消息
 * @createdTime 2022/2/1 13:01
 */
public class SimpleMessage implements Serializable {

    private static final long serialVersionUID = -1611416820929263656L;

    /**
     * 通知的内容
     */
    private String notifyJson;

    public String getNotifyJson() {
        return notifyJson;
    }

    public void setNotifyJson(String notifyJson) {
        this.notifyJson = notifyJson;
    }
}
