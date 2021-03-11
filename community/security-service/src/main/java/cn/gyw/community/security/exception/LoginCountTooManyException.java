package cn.gyw.community.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 返回登陆请求过于频繁的异常
 */
public class LoginCountTooManyException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public LoginCountTooManyException(String msg, Throwable t) {
        super(msg, t);
    }

    public LoginCountTooManyException(String msg) {
        super(msg);
    }
}
