package cn.gyw.community.rest.post.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "rest_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String CREATED_TIME = "created_time";

    /**
     * 帖子编号
     */
    @Id
    private Integer uid;

    /**
     * 帖子标题
     */
    private String postTitle;
	/**
	 * 帖子概要
	 */
	private String postResume;
    /**
     * 帖子内容
     */
    private String postContent;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建人编号
     */
    private Integer createdById;

    /**
     * 是否删除 0:否；1:是；
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;
    
	private Long reading = 0L; // 访问量、阅读量
	 
	private Long comments = 0L;  // 评论量

	private Long likes = 0L;  // 点赞量

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostResume() {
		return postResume;
	}

	public void setPostResume(String postResume) {
		this.postResume = postResume;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
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

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Long getReading() {
		return reading;
	}

	public void setReading(Long reading) {
		this.reading = reading;
	}

	public Long getComments() {
		return comments;
	}

	public void setComments(Long comments) {
		this.comments = comments;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Post [uid=" + uid + ", postTitle=" + postTitle + ", postResume=" + postResume + ", postContent="
				+ postContent + ", createdBy=" + createdBy + ", createdById=" + createdById + ", deleted=" + deleted
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", reading=" + reading
				+ ", comments=" + comments + ", likes=" + likes + "]";
	}

}
