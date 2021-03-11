package cn.gyw.community.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class CommentDto implements Serializable {
    private static final long serialVersionUID = 6001191644992005525L;

    private Integer id;
    private String fromAvatar = "https://profile.csdnimg.cn/8/0/6/3_w605283073"; // TODO
    private String content;
    private Integer likeNum;
    private String postId;
    private String createdBy;
    private Integer createdById;
    
    @JsonFormat(pattern = "yy/MM/dd HH:mm", timezone = "GMT+8")
    private LocalDateTime createdTime;
    
    private List<ReplyDto> replys;

    public CommentDto() {
    }

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

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public List<ReplyDto> getReplys() {
        return replys;
    }

    public void setReplys(List<ReplyDto> replys) {
        this.replys = replys;
    }

    public String getFromAvatar() {
        return fromAvatar;
    }

    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }

}
