package cn.gyw.components.web.model;

import cn.gyw.components.web.enums.CommonResponseEnum;

/**
 * 通用返回对象
 * @param <T>
 */
public class DataResponse<T> extends BaseResponse {
    private static final long serialVersionUID = 1L;
    
    T data;

    public static <T> DataResponse<T> success(T data) {
        DataResponse<T> result = new DataResponse<>();
        result.setCode(CommonResponseEnum.SUCCESS.getCode());
        result.setMessage(CommonResponseEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
