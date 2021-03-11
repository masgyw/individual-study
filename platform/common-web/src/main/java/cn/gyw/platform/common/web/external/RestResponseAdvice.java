package cn.gyw.platform.common.web.external;

import java.lang.reflect.Type;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.google.gson.Gson;

import cn.gyw.platform.common.web.constants.BaseConstants;
import cn.gyw.platform.common.web.model.BaseResponse;
import cn.gyw.platform.common.web.model.DataResponse;

/**
 * 返回值封装
 */
@ControllerAdvice
public class RestResponseAdvice implements ResponseBodyAdvice<Object> {

    private final Logger LOGGER = LoggerFactory.getLogger(RestResponseAdvice.class);

    private static final String IGNORE_CLASS = "cn.gyw.community.system.controller.SysLogController";
    
    @SuppressWarnings("rawtypes")
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        Class<?> controllerClass = returnType.getContainingClass();
        boolean isSupported = controllerClass.isAnnotationPresent(RestController.class)
                || controllerClass.isAnnotationPresent(ResponseBody.class)
                || returnType.getMethodAnnotation(ResponseBody.class) != null
                || controllerClass.equals(UnifiedExceptionHandler.class);
        LOGGER.debug("{} is supported:{}", controllerClass.getSimpleName(), isSupported);
        return isSupported;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Object resp = null;
        if (body != null) {
            LOGGER.info("return body class type: [{}]", body.getClass());
            resp = body;
        }
        if (request instanceof ServletServerHttpRequest) {
            if (Objects.nonNull(resp) && !(resp instanceof BaseResponse)) {
                resp = DataResponse.success(body);
                Type paramType = returnType.getGenericParameterType();
                LOGGER.debug("return type:{}, response:{}", paramType, resp);
            }
        } else {
            LOGGER.debug("request not servlet web");
        }
        if (!IGNORE_CLASS.equals(returnType.getContainingClass().getName())) {
            HttpHeaders headers = response.getHeaders();
            headers.set(BaseConstants.HEADER_RESPONSE_OBJECT, new Gson().toJson(resp));
            LOGGER.debug("Not ignore controller class, set header[responseObject] success");
        }
        return resp;
    }
}
