package cn.gyw.platform.common.web.exceptions;

import cn.gyw.platform.common.web.IRespCode;

/**
 * 通用异常类
 */
public class CommonException extends BaseException {

	private static final long serialVersionUID = 1L;

	public CommonException(IRespCode resp) {
		super(resp);
	}

	public CommonException(IRespCode resp, Object[] args, String message) {
		super(resp, args, message);
	}

	public CommonException(IRespCode resp, Object[] args, String message, Throwable t) {
		super(resp, args, message, t);
	}

}
