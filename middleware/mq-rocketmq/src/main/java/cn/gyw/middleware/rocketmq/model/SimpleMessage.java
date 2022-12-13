package cn.gyw.middleware.rocketmq.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 消息模型
 *
 * @author yuewu.guan
 * @date 2022/1/30 10:03
 */
public class SimpleMessage implements Serializable {

    private Integer id;
    private String content;
    private LocalDateTime createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
