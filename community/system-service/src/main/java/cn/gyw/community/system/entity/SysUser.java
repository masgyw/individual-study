package cn.gyw.community.system.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author guanyw
 * @since 2020-03-05
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String UID = "uid";
    public static final String USER_ID = "uid";
    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";

    /**
     * 用户编号
     */
    @Id
    private Integer uid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户姓名
     */
    private String userNameCn;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 用户角色
     */
    private Integer roleId;

    /**
     * 用户状态：0 启用；1 禁用；
     */
    private Integer status;
    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameCn() {
        return userNameCn;
    }

    public void setUserNameCn(String userNameCn) {
        this.userNameCn = userNameCn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
