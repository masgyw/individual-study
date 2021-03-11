package cn.gyw.components.web.exceptions;

import cn.gyw.components.web.enums.IResponseEnum;

/**
 * 通用异常类
 */
public class CommonException extends BaseException {

	private static final long serialVersionUID = 1L;

	public CommonException(IResponseEnum resp) {
		super(resp);
	}

	public CommonException(IResponseEnum resp, Object[] args, String message) {
		super(resp, args, message);
	}

	public CommonException(IResponseEnum resp, Object[] args, String message, Throwable t) {
		super(resp, args, message, t);
	}

}
