package cn.gyw.platform.common.web.exceptions;

import java.util.Arrays;

import cn.gyw.platform.common.web.IRespCode;

/**
 * 基础异常
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private IRespCode respCode;

    private Object[] args;

    public BaseException(IRespCode respCode) {
        this(respCode, null, null, null);
    }

    public BaseException(IRespCode respCode, Object[] args, String message) {
        this(respCode, args, message, null);
    }

    public BaseException(IRespCode respCode, Object[] args, String message, Throwable t) {
        super(String.join(",", message, Arrays.toString(args)), t);
        this.respCode = respCode;
        this.args = args;
    }

    public IRespCode getRespCode() {
		return respCode;
	}

    public Object[] getArgs() {
        return args;
    }
}
