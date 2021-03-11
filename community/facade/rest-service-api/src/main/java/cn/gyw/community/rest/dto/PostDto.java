package cn.gyw.community.rest.dto;

import java.io.Serializable;

/**
 * C <---> Controller
 */
public class PostDto implements Serializable {

    private static final long serialVersionUID = -110913598638319241L;

    /**
     * 帖子编号
     */
    private Integer uid;

    /**
     * 帖子标题
     */
    private String postTitle;

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

    //@NeedSetValueField(beanClass = UserService.class, method = "dummyUser", param="createdById", targetField = "userName")
    private String userName;
    
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

}
