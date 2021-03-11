package cn.gyw.components.web.exceptions;

import java.text.MessageFormat;

import cn.gyw.components.web.enums.IResponseEnum;

public interface CommonExceptionAssert extends IResponseEnum, ExceptionAssert {

	@Override
	default BaseException newException(Object... args) {
		String message = MessageFormat.format(this.getMessage(), args);
		return new CommonException(this, args, message);
	}
	
	@Override
	default BaseException newException(Throwable t, Object... args) {
		String message = MessageFormat.format(this.getMessage(), args);
		return new CommonException(this, args, message, t);
	}
}
