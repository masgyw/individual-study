package cn.gyw.components.web.log;

import cn.gyw.components.web.constants.BaseConstants;
import cn.gyw.components.web.log.entity.ApiLog;
import cn.gyw.components.web.log.event.ApiLogEvent;
import cn.gyw.components.web.utils.JwtTokenUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * interceptor 拦截规则：
 *  preHandle ：低优先级 -> 高优先级
 *  postHandle：高优先级 -> 低优先级
 *  afterCompletion：高优先级 -> 低优先级
 *  
 *  全局接口请求api
 */
public class GlobalApiLogInterceptor implements HandlerInterceptor, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalApiLogInterceptor.class);

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public GlobalApiLogInterceptor(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        ApiLog apiLog = new ApiLog();
        handleRequest(request, apiLog);
        handleResponse(response, apiLog);
        eventPublisher.publishEvent(new ApiLogEvent(apiLog));
    }

    private void handleRequest(HttpServletRequest request, ApiLog apiLog) throws IOException {
        String token = request.getHeader("X-Token");
        if (!StringUtils.isEmpty(token)) {
            String userId = JwtTokenUtil.getUserId(token);
            apiLog.setLoginAccount(userId);
        }
        apiLog.setActionUrl(request.getRequestURI());
        apiLog.setDescription(request.getRequestURL().toString());
        apiLog.setMethod(request.getMethod());
        apiLog.setGmtCreate(new Date());
        apiLog.setRequestData(request.getQueryString());
        apiLog.setModule(request.getContextPath());
        apiLog.setHost(request.getServerName());
        apiLog.setPort(String.valueOf(request.getServerPort()));
    }

    private void handleResponse(HttpServletResponse response, ApiLog apiLog) {
        String respJson = response.getHeader(BaseConstants.HEADER_RESPONSE_OBJECT);
        if (StringUtils.isEmpty(respJson)) {
            LOGGER.warn("response header do not have responseObject");
            return ;
        }
        JsonObject jsonObject = new Gson().fromJson(respJson, JsonObject.class);
        apiLog.setResponseData(respJson);
        apiLog.setResponseCode(jsonObject.get(BaseConstants.FIELD_RESPONSE_CODE).getAsString());
        response.setHeader(BaseConstants.HEADER_RESPONSE_OBJECT, "");
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
