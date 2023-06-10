package cn.gyw.springboot.webmvc.common;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public final class JsonResult<E> {

    private static final String SUCCESS_CODE = "0";
    private static final String SUCCESS_MSG = "success";

    @Setter(AccessLevel.PRIVATE)
    private String code;
    @Setter(AccessLevel.PRIVATE)
    private String msg;
    @Setter(AccessLevel.PRIVATE)
    private E rows;

    private JsonResult() {
    }

    public static <E> JsonResult<E> success(E e) {
        JsonResult<E> object = new JsonResult<>();
        object.setCode(SUCCESS_CODE);
        object.setMsg(SUCCESS_MSG);
        object.setRows(e);
        return object;
    }

    public static <E> JsonResult<E> success(E t, String msg) {
        JsonResult<E> obj = success(t);
        obj.setMsg(msg);
        return obj;
    }

    public static JsonResult FAIL(ResultEnum resultEnum) {
        JsonResult object = new JsonResult();
        object.setMsg(resultEnum.getDesc());
        object.setCode(resultEnum.getCode());
        return object;
    }

    public static JsonResult FAIL(String msg) {
        JsonResult object = new JsonResult();
        object.setMsg(msg);
        object.setCode(ResultEnum.FAIL.getCode());
        return object;
    }

    public static <E> JsonResult<E> FAIL(E e, String msg) {
        JsonResult<E> object = new JsonResult<>();
        object.setCode(ResultEnum.FAIL.getCode());
        object.setMsg(msg);
        object.setRows(e);
        return object;
    }

    public static <E> JsonResult<E> res(ResultEnum resultEnum, E e) {
        JsonResult<E> object = new JsonResult<>();
        object.setMsg(resultEnum.getDesc());
        object.setCode(resultEnum.getCode());
        object.setRows(e);
        return object;
    }

    public boolean isSuccess() {
        return Objects.equals(SUCCESS_CODE, this.getCode());
    }
}
