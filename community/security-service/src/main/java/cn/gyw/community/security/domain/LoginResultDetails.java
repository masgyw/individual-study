package cn.gyw.community.security.domain;

import cn.gyw.community.security.model.CommunityUser;

/**
 * 登陆成功后返回用户信息
 */
public class LoginResultDetails {
	
	private Integer status;
	private ResultDetails resultDetails;
	private CommunityUser user;

	public ResultDetails getResultDetails() {
		return resultDetails;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setResultDetails(ResultDetails resultDetails) {
		this.resultDetails = resultDetails;
	}

	public CommunityUser getUser() {
		return user;
	}

	public void setUser(CommunityUser user) {
		this.user = user;
	}
}
