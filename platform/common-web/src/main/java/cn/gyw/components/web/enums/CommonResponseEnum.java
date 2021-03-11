package cn.gyw.components.web.enums;

import cn.gyw.components.web.exceptions.CommonExceptionAssert;

/**
 * 通用返回
 */
public enum CommonResponseEnum implements CommonExceptionAssert {

	SUCCESS(20000, "Success"), SERVER_ERROR(50001, "Server error");

	private CommonResponseEnum(int code, String message) {
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
