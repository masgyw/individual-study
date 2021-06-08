package cn.gyw.platform.common.web.model;

import cn.gyw.platform.common.web.IRespCode;

import java.io.Serializable;

/**
 * 基础返回对象
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 2951887768275356440L;
    
    // 错误编码
    protected int errorCode;
    // 结果编码
    protected int code;
    // 结果信息
    protected String message;

    public BaseResponse() {
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public static BaseResponse error(int code, String message) {
        return new BaseResponse(code, message);
    }

    public static BaseResponse error(IRespCode respCode) {
        return error(respCode.getCode(), respCode.getMessage());
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
