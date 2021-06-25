package cn.gyw.community.system.enums;

import cn.gyw.platform.common.web.exceptions.BusinessExceptionAssert;

public enum SystemRespEnum implements BusinessExceptionAssert {
    REGISTER_FAILED(11001, "Register failed"),
    LOGIN_FAILED(11002, "用户名或密码不正确"),
    USER_DISABLE(11003, "用户禁用"),
    PASSWORD_ERROR(11004, "密码不正确"),
    ;

    private int code;
    private String message;

    SystemRespEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
