package cn.gyw.platform.notify.service;

/**
 * @desc 通知服务
 * @createdTime 2022/2/12 13:11
 */
public interface NotifyService {

    /**
     * 发送通知
     *
     * @param title   标题
     * @param content 内容
     */
    boolean sendNotify(String title, String content);

}
