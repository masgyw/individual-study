package cn.gyw.components.web.enums;

import cn.gyw.components.web.exceptions.BusinessExceptionAssert;

/**
 * 针对业务模块
 * 
 * 部分异常情况是通用的，比如：服务器繁忙、网络异常、服务器异常、参数校验异常、404 等
 * 
 * CommonResponseEnum、ArgumentResponseEnum、ServletResponseEnum
 * 
 * 每一个枚举针对一个异常
 */
public enum BusinessExceptionEnum implements BusinessExceptionAssert {
    
    BAD_LICENCE_TYPE(30001, "Bad licence type"), 
    LICENCE_NOT_FOUND(30002, "Licence not found"),
    TOKEN_ILLEGAL(30003, "Token illegal"),
    TOKEN_IN_USE(30004, "Other clients logged in"),
    TOKEN_EXPIRED(30005, "Token expired"),
    ;

    private BusinessExceptionEnum(int code, String message) {
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
