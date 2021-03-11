package cn.gyw.components.web.exceptions;

import cn.gyw.components.web.enums.IResponseEnum;

/**
 * 基础异常
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private IResponseEnum responseEnum;

    private Object[] args;

    public BaseException(IResponseEnum resp) {
        this(resp, null, null, null);
    }

    public BaseException(IResponseEnum resp, Object[] args, String message) {
        this(resp, args, message, null);
    }

    public BaseException(IResponseEnum resp, Object[] args, String message, Throwable t) {
        super(message, t);
        this.responseEnum = resp;
        this.args = args;
    }

    public IResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public Object[] getArgs() {
        return args;
    }
}
