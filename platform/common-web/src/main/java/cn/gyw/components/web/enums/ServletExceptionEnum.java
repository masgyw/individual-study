package cn.gyw.components.web.enums;

import cn.gyw.components.web.exceptions.CommonExceptionAssert;

/**
 * Servlet 异常
 */
public enum ServletExceptionEnum implements CommonExceptionAssert {

    SERVER_ERROR(50000, "Server error");

    private ServletExceptionEnum(int code, String message) {
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
