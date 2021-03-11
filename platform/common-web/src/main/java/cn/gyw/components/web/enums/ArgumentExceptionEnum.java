package cn.gyw.components.web.enums;

import cn.gyw.components.web.exceptions.CommonExceptionAssert;

/**
 * 参数异常
 */
public enum ArgumentExceptionEnum implements CommonExceptionAssert {

	VALID_ERROR(40001, "argument valid error"),
	NULL_ERROR(40002, "argument [{0}] is null");

	private ArgumentExceptionEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private int code;
	private String message;

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
