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

	public CommonException(IRespCode resp, Object[] args) {
		super(resp, args);
	}

	public CommonException(IRespCode resp, Object[] args, Throwable t) {
		super(resp, args, t);
	}

}
