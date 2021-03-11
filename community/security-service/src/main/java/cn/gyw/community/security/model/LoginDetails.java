package cn.gyw.community.security.model;

/**
 * 登陆详情
 */
public class LoginDetails {
	
    private Boolean rememberMe;
    private String verifyCode;

    public LoginDetails(Boolean rememberMe, String verifyCode) {
        this.rememberMe = rememberMe;
        this.verifyCode = verifyCode;
    }

    public LoginDetails() {}

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

	@Override
	public String toString() {
		return "LoginDetails [rememberMe=" + rememberMe + ", verifyCode=" + verifyCode + "]";
	}
}
