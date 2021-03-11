package cn.gyw.community.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证失败异常
 */
public class VerifyFailedException extends AuthenticationException {
	
	private static final long serialVersionUID = 1L;

	public VerifyFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public VerifyFailedException(String msg) {
        super(msg);
    }
}
