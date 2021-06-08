package cn.gyw.platform.common.web.enums;

import cn.gyw.platform.common.web.exceptions.CommonExceptionAssert;

/**
 * 通用返回
 */
public enum CommonRespEnum implements CommonExceptionAssert {

	SUCCESS(20000, "Success"),

	PARAM_NOT_NULL(40001, "argument not null"),
	PARAM_NULL(40002, "argument [{0}] is null"),

	SERVER_ERROR(50001, "Server internal error"),
	NO_DATA(50002, "No data"),
	TOKEN_ILLEGAL(50003, "Token illegal")
	;

	CommonRespEnum(int code, String message) {
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
