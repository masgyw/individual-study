package cn.gyw.platform.common.web.exceptions;

import cn.gyw.platform.common.web.IRespCode;

public interface CommonExceptionAssert extends IRespCode, IExceptionAssert {

	@Override
	default BaseException newException(Object... args) {
		return new CommonException(this, args);
	}
	
	@Override
	default BaseException newException(Throwable t, Object... args) {
		return new CommonException(this, args, t);
	}
}
