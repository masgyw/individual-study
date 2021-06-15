package cn.gyw.platform.common.web.aop;

import java.lang.reflect.Type;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import cn.gyw.platform.common.web.exceptions.GlobalExceptionHandler;
import cn.gyw.platform.common.web.model.BaseResponse;
import cn.gyw.platform.common.web.model.DataResponse;

/**
 * 返回值封装
 */
@ControllerAdvice
public class RestResponseAdvice implements ResponseBodyAdvice<Object> {

    private final Logger LOGGER = LoggerFactory.getLogger(RestResponseAdvice.class);

    @SuppressWarnings("rawtypes")
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Class<?> controllerClass = returnType.getContainingClass();
        boolean isSupported = controllerClass.isAnnotationPresent(RestController.class)
                || controllerClass.isAnnotationPresent(ResponseBody.class)
                || returnType.getMethodAnnotation(ResponseBody.class) != null
                || controllerClass.equals(GlobalExceptionHandler.class);
        LOGGER.debug("{} is supported:{}", controllerClass.getSimpleName(), isSupported);
        return isSupported;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object resp = null;
        if (body != null) {
            LOGGER.info("Return body class type: [{}]", body.getClass());
            resp = body;
        }
        if (request instanceof ServletServerHttpRequest) {
            if (Objects.nonNull(resp) && !(resp instanceof BaseResponse)) {
                resp = DataResponse.success(body);
                Type paramType = returnType.getGenericParameterType();
                LOGGER.debug("Return type:{}, response:{}", paramType, resp);
            }
        } else {
            LOGGER.debug("request not servlet web");
        }
        return resp;
    }
}
