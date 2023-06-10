package cn.gyw.springboot.webmvc.handler;

import cn.gyw.springboot.webmvc.common.JsonResult;
import cn.gyw.springboot.webmvc.common.ResultEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @date 2023/6/10
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JsonResult<?> errorHandler(Exception e) {
        return JsonResult.FAIL(ResultEnum.FAIL);
    }
}
