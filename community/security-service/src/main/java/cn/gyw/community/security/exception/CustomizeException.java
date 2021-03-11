package cn.gyw.community.security.exception;

/**
 * 自定义异常
 */
public class CustomizeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CustomizeException() {
        super();
    }

    public CustomizeException(String message) {
        super(message);
    }

    public CustomizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeException(Throwable cause) {
        super(cause);
    }

    protected CustomizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
