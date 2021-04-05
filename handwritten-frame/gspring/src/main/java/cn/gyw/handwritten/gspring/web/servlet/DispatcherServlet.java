package cn.gyw.handwritten.gspring.webmvc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.*;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 保存扫描到的类名
	private static List<String> classNameList = new ArrayList<>();

	// IOC 容器
	private static Map<String, Object> ioc = new HashMap<>();

	// url - method 映射
//	private static Map<String, Method> handlerMappings = new HashMap<>();
	private List<HandlerMapping> handlerMappings = new ArrayList<>();

	// 保存properties 文件的属性配置
	private final Properties contextConfig = new Properties();

	// 初始化，扫描 实例化（IOC MAP） 、DI（Autowired）、url-method-mapping
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 1、加载配置文件 application.properties
		doLoadConfig(config.getInitParameter("contextConfigLocation"));
		// 2、扫描 class 实例
		doScanPackage(contextConfig.getProperty("base.package"));
		// 3、初始化
		doInstance();
		// 4、DI 依赖注入
		doAutowired();
		// 5、初始化HandleMapping，url- method 映射
		initHandleMapping();

		System.out.println("My mvc start success!");
	}

	private void doLoadConfig(String configName) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configName);
		try {
			contextConfig.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 扫描实例化，创建IOC 容器。XML， basePackage = "com.gyw"
	private void doScanPackage(String scanPackage) {
		// D:\Workspaces\workspace-photon\SimpleFramework\simple-mvc\target\classes\com\gyw
		ClassLoader cl = this.getClass().getClassLoader();
		URL url = cl.getResource(scanPackage.replace(".", "/"));
		File rootFile = new File(url.getFile());
		for (File file : rootFile.listFiles()) {
			// 手动跳过 annotation
			if (file.isDirectory()) {
				// 递归查找.class 文件
				doScanPackage(scanPackage + "." + file.getName());
			} else {
				// 非class 文件跳过
				if (!file.getName().endsWith(".class")) {
					continue;
				}
//				System.out.println(file.getName() + " add in class list!");
				// .class 文件结尾的文件
				classNameList.add(scanPackage + "." + file.getName().replace(".class", ""));
			}
		}
	}

	/**
	 * 初始化IOC 容器
	 */
	private void doInstance() {

		try {
			// className = com.gyw.simple.mvc.controller.CustomController.class
			for (String className : classNameList) {
				// com.gyw.simple.mvc.controller.CustomController
				Class<?> claz = Class.forName(className);
				if (claz.isAnnotationPresent(MyController.class)) {
					// 控制类
					Object instance = claz.newInstance();
					// spring 类名默认首字母小写
					String beanName = toLowerFirstCase(claz.getSimpleName());
					ioc.put(beanName, instance);
				} else if (claz.isAnnotationPresent(MyService.class)) {
					// 1. 自定义beanName
					MyService myService = claz.getAnnotation(MyService.class);
					String beanName = myService.name();
					if ("".equals(beanName.trim())) {
						// 2. 默认beanName 为首字母小写
						beanName = toLowerFirstCase(claz.getSimpleName());
					}
					Object instance = claz.newInstance();
					ioc.put(beanName, instance);

					// 3. 根据类型自动赋值
					for (Class<?> i : claz.getInterfaces()) {
						if (ioc.containsKey(i.getName())) {
							throw new RuntimeException("The class [" + i.getName() + "] is exists!");
						}
						ioc.put(i.getName(), instance);
					}
				} else {
					continue;
				}
			}
			ioc.forEach((key, value) -> {
				System.out.println("bean : " + key + " --- " + value);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 不存在类名首字母小写的情况及非字母的情况
	 *
	 * @param simpleName
	 * @return
	 */
	private String toLowerFirstCase(String simpleName) {
		char[] chars = simpleName.toCharArray();
		// a - A = 32 ascii 码
		chars[0] += 32;
		return String.valueOf(chars);
	}

	/**
	 * 依赖注入
	 */
	private void doAutowired() {
		if (ioc.isEmpty()) {
			return;
		}

		for (Map.Entry<String, Object> entry : ioc.entrySet()) {
			Object instance = entry.getValue();
			// 获取所有字段属性
			Field[] fields = instance.getClass().getDeclaredFields();

			Class<?> clazz = instance.getClass();
			for (Field field : fields) {
				if (!field.isAnnotationPresent(MyAutowired.class)) {
					continue;
				}
				MyAutowired myAutowired = field.getAnnotation(MyAutowired.class);
				// 若没有指定beanName，根据类型注入
				String beanName = myAutowired.value().trim();
				if ("".equals(beanName)) {
					// 类型注入
					beanName = field.getType().getName();
				}
				// private 提供权限
				field.setAccessible(true);
				try {
					field.set(instance, ioc.get(beanName));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// 控制类
			if (clazz.isAnnotationPresent(MyController.class)) {
				for (Field field : fields) {
					if (field.isAnnotationPresent(MyAutowired.class)) {
						String key = field.getAnnotation(MyAutowired.class).value();
						// private 提供权限
						field.setAccessible(true);

						try {
							field.set(instance, ioc.get(key));
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
	}

	public void initHandleMapping() {
		if (ioc.isEmpty())
			return;

		for (Map.Entry<String, Object> entry : ioc.entrySet()) {
			Object instance = entry.getValue();
			Class<?> clazz = instance.getClass();
			if (!clazz.isAnnotationPresent(MyController.class)) {
				continue;
			}
			String baseUrl = clazz.getAnnotation(MyRequestMapping.class).value();

			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (!method.isAnnotationPresent(MyRequestMapping.class)) {
					continue;
				}
				String url = (baseUrl + "/" + method.getAnnotation(MyRequestMapping.class).value()).replaceAll("/+",
						"/");
				handlerMappings.add(new HandlerMapping(url, instance, method));
				System.out.println(String.format("Mapped url :%s, method :%s", url, method.getName()));
			}
		}
	}

	// tomcat 初始化完成后，开始拦截
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doDispatch(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("500 server error :" + Arrays.toString(e.getStackTrace()));
		}
	}

	private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HandlerMapping handlerMapping = getHandlerMapping(request);
		if (handlerMapping == null) {
			response.getWriter().write("404 not found !");
			return;
		}
		// 方法的形参列表
		Class<?>[] parameterTypes = handlerMapping.getParameterTypes();

		// 请求参数
		Map<String, String[]> params = request.getParameterMap();
		// 参数数组
		Object[] paramValues = new Object[parameterTypes.length];
		for (Map.Entry<String, String[]> paramEntry : params.entrySet()) {
			if (!handlerMapping.paramIndexMapping.containsKey(paramEntry.getKey())) {
				continue;
			}
			String value = Arrays.toString(paramEntry.getValue()).replaceAll("\\[\\]", "").replaceAll("\\s", "");
			int idx = handlerMapping.paramIndexMapping.get(paramEntry.getKey());
			paramValues[idx] = convert(parameterTypes[idx], value);
		}
		if (handlerMapping.paramIndexMapping.containsKey(HttpServletRequest.class.getName())) {
			int reqIdx = handlerMapping.paramIndexMapping.get(HttpServletRequest.class.getName());
			paramValues[reqIdx] = request;
		}
		if (handlerMapping.paramIndexMapping.containsKey(HttpServletResponse.class.getName())) {
			int respIdx = handlerMapping.paramIndexMapping.get(HttpServletResponse.class.getName());
			paramValues[respIdx] = response;
		}
		System.out.println("params :" + Arrays.toString(paramValues));
		// 方法执行
		Object returnValue = handlerMapping.getMethod().invoke(handlerMapping.getHandler(), paramValues);
		if (returnValue == null || returnValue instanceof Void) {
			return ;
		}
		response.getWriter().write(returnValue.toString());
	}

	private HandlerMapping getHandlerMapping(HttpServletRequest request) {
		// 获取到请求路径 -- method 的映射
		// url全路径 /rootPath/{apiPath}
		String urlPath = request.getRequestURI();
		// 项目根路径
		String contentPath = request.getContextPath();
		urlPath = urlPath.replace(contentPath, "").replaceAll("/+", "/");
		for (HandlerMapping hm : this.handlerMappings) {
			if (hm.getUrl().equals(urlPath)) {
				return hm;
			}
		}
		return null;
	}

	/**
	 * 类型转换
	 *
	 * @param type
	 * @return
	 */
	private Object convert(Class<?> type, String value) {
		if (String.class.equals(type)) {
			return value.replaceAll("\\[\\]", "").replaceAll("\\s", ",");
		}
		if (Integer.class.equals(type)) {
			return Integer.valueOf(value);
		}
		return value;
	}

	private class HandlerMapping {

		String url;
		Method method;
		Object handler;
		Class<?>[] parameterTypes;
		// 参数名称-索引映射
		Map<String, Integer> paramIndexMapping;

		public HandlerMapping(String url, Object handler, Method method) {
			this.url = url;
			this.handler = handler;
			this.method = method;
			this.parameterTypes = method.getParameterTypes();
			paramIndexMapping = new HashMap<>();
			putParamIndexMapping(method);
		}

		private void putParamIndexMapping(Method method) {
			// 提取方法中加了注解的参数
			Annotation[][] pa = method.getParameterAnnotations(); // 方法有多个参数，参数有多个注解
			Parameter[] parameters = method.getParameters();
			for (int i = 0, len = parameterTypes.length; i < len; i++) {
				// 若存在注解，使用注解为 key
				for (Annotation annotation : pa[i]) {
					if (annotation instanceof MyRequestParam) {
						MyRequestParam mrp = (MyRequestParam) annotation;
						if (!"".equals(mrp.value())) {
							paramIndexMapping.put(mrp.value(), i);
						} else {
							// From jdk8 support get parameter name
							// 若没有注解，使用形参名称
							paramIndexMapping.put(parameters[i].getName(), i);
						}
					}
				}
				// Request/Response 使用类型
				Class<?> paramType = parameterTypes[i];
				if (HttpServletRequest.class.isAssignableFrom(paramType)
						|| HttpServletResponse.class.isAssignableFrom(paramType)) {
					paramIndexMapping.put(paramType.getName(), i);
					continue;
				}
			}

			System.out.println(this.url + " [params/index] mapping :" + paramIndexMapping);
		}

		public String getUrl() {
			return url;
		}

		public Method getMethod() {
			return method;
		}

		public Object getHandler() {
			return handler;
		}

		public Class<?>[] getParameterTypes() {
			return parameterTypes;
		}
	}

}
