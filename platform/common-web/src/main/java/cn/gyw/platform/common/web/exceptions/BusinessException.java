package cn.gyw.platform.common.web.exceptions;

import cn.gyw.platform.common.web.enums.IResponseEnum;

/**
 * 业务相关异常
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(IResponseEnum resp, Object[] args, String message) {
        super(resp, args, message);
    }

    public BusinessException(IResponseEnum resp, Object[] args, String message, Throwable t) {
        super(resp, args, message, t);
    }
}
