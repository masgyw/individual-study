package cn.gyw.platform.notify.model;

import org.springframework.context.ApplicationEvent;

/**
 * @desc 监听事件
 * @createdTime 2022/2/1 12:48
 */
public class NotifyEvent extends ApplicationEvent {
    private static final long serialVersionUID = 495939031691685279L;

    /**
     * 消息标题
     */
    private String msgTitle;
    /**
     * 消息内容
     */
    private String msgContent;

    public NotifyEvent(Object source) {
        super(source);
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgContent() {
        return msgContent;
    }

    @Override
    public String toString() {
        return "MonitorEvent{" +
                "msgTitle='" + msgTitle + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", source=" + source +
                '}';
    }
}
