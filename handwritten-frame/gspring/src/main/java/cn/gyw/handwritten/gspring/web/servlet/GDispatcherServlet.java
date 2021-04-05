package cn.gyw.handwritten.gspring.web.servlet;

import cn.gyw.handwritten.gspring.context.GApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MVC
 */
public class GDispatcherServlet extends HttpServlet {

    private final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDispatch(req, resp);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1. ApplicationContext 初始化
        GApplicationContext context = new GApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));

        // 2. MVC 6大组件初始化
        initStrategies(context);
    }

    // 初始化策略
    protected void initStrategies(GApplicationContext context) {
        // 多文件上传的组件
        initMultipartResolver(context);
        // 初始化本地语言环境
        initLocaleResolver(context);
        // 初始化主题解析器
        initThemeResolver(context);

        // 初始化HandlerMapping，必须实现
        initHandlerMappings(context);
        // 初始化Handler适配器，必须实现
        initHandlerAdapters(context);

        // 初始化异常拦截器
        initHandlerExceptionResolvers(context);
        // 初始化视图预处理器
        initRequestToViewNameTranslator(context);
        // 初始化试图转换器，必须实现
        initViewResolvers(context);

        // 初始化闪存管理器
        initFlashMapManager(context);
    }

    private void initFlashMapManager(GApplicationContext context) {
    }

    private void initViewResolvers(GApplicationContext context) {
    }

    private void initRequestToViewNameTranslator(GApplicationContext context) {
    }

    private void initHandlerExceptionResolvers(GApplicationContext context) {
    }

    private void initHandlerAdapters(GApplicationContext context) {
    }

    private void initHandlerMappings(GApplicationContext context) {
    }

    private void initThemeResolver(GApplicationContext context) {
    }

    private void initLocaleResolver(GApplicationContext context) {
    }

    private void initMultipartResolver(GApplicationContext context) {
    }
}
