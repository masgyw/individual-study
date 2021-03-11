package cn.gyw.platform.common.web.model;

import java.io.Serializable;

import cn.gyw.platform.common.web.constants.ErrorConstants;

/**
 * 基础返回对象
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 2951887768275356440L;
    
    // 错误编码，0：成功
    protected int errorCode = ErrorConstants.ERR_OK;
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
        BaseResponse errorResponse = new BaseResponse(code, message);
        errorResponse.setErrorCode(ErrorConstants.ERR_INTERNAL_ERROR);
        return errorResponse;
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

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
