package cn.gyw.components.web.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.gyw.components.web.enums.ArgumentExceptionEnum;
import cn.gyw.components.web.enums.CommonResponseEnum;
import cn.gyw.components.web.enums.ServletExceptionEnum;
import cn.gyw.components.web.exceptions.BaseException;
import cn.gyw.components.web.exceptions.BusinessException;
import cn.gyw.components.web.model.BaseResponse;

/**
 * 统一异常处理
 */
@Component
@ConditionalOnWebApplication
//@ConditionalOnMissingBean(UnifiedExceptionHandler.class) // 和上面的注解冲突
@RestControllerAdvice
public class UnifiedExceptionHandler {

	private final static Logger LOGGER = LoggerFactory.getLogger(UnifiedExceptionHandler.class);
	
	private final static String ENV_PROD = "prod";

	@Value("${spring.profiles.active}")
	private String profile;

	@Autowired
	private UnifiedMessageSource unifiedMessageSource;

	public String getMessage(BaseException e) {
		/*
		 * String code = "response." + e.getResponseEnum().toString(); String message =
		 * unifiedMessageSource.getMessage(code, e.getArgs()); if (message == null ||
		 * message.isEmpty()) { return e.getMessage(); }
		 */
		String message = e.getMessage();
		return message;
	}

	@ExceptionHandler(value = BusinessException.class)
	public BaseResponse handleBusinessException(BaseException e) {
		LOGGER.error("{}", e);
		return BaseResponse.error(e.getResponseEnum().getCode(), getMessage(e));
	}

	@ExceptionHandler(value = BaseException.class)
	public BaseResponse handleBaseException(BaseException e) {
		LOGGER.error("{}", e);
		return BaseResponse.error(e.getResponseEnum().getCode(), getMessage(e));
	}

	/**
	 * Controller 上一层异常处理
	 * 
	 * servletException ==> Controller ==> BaseException ==> Service
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class,
			HttpMediaTypeNotSupportedException.class, MissingPathVariableException.class,
			MissingServletRequestParameterException.class, TypeMismatchException.class,
			HttpMessageNotReadableException.class, HttpMessageNotWritableException.class,
			// BindException.class,
			// MethodArgumentNotValidException.class
			HttpMediaTypeNotAcceptableException.class, ServletRequestBindingException.class,
			ConversionNotSupportedException.class, MissingServletRequestPartException.class,
			AsyncRequestTimeoutException.class })
	public BaseResponse handleServletException(Exception e) {
		LOGGER.error("", e);
		int code = CommonResponseEnum.SERVER_ERROR.getCode();
		try {
			ServletExceptionEnum servletResponseEnum = ServletExceptionEnum.valueOf(e.getClass().getSimpleName());
			code = servletResponseEnum.getCode();
		} catch (IllegalArgumentException ex) {
			System.out.println(e.getClass().getName() + ServletExceptionEnum.class.getName());
		}

		if (ENV_PROD.equals(profile)) {
			// 当为生产环境, 不适合把具体的异常信息展示给用户, 比如404.
			code = CommonResponseEnum.SERVER_ERROR.getCode();
			BaseException baseException = new BaseException(CommonResponseEnum.SERVER_ERROR);
			String message = getMessage(baseException);
			return BaseResponse.error(code, message);
		}
		
		return BaseResponse.error(code, e.getMessage());
	}
	
	/**
	 * 参数绑定异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = BindException.class)
	public BaseResponse handleBindException(BindException e) {
		LOGGER.error("{}", e);
		return wrapperBindingResult(e.getBindingResult());
	}

	private BaseResponse wrapperBindingResult(BindingResult bindResult) {
		StringBuilder msg = new StringBuilder();
		for (ObjectError error : bindResult.getAllErrors()) {
			msg.append(", ");
			if (error instanceof FieldError) {
				msg.append(((FieldError) error).getField()).append(":");
			}
			msg.append(error.getDefaultMessage() == null ? "" : error.getDefaultMessage());
		}
		
		return BaseResponse.error(ArgumentExceptionEnum.VALID_ERROR.getCode(), msg.substring(2));
	}
	
	/**
	 * 未定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public BaseResponse handleException(Exception e) {
		LOGGER.error("No defind exception :", e);
		if (ENV_PROD.equals(profile)) {
			// 生产环境异常处理
		}
		return BaseResponse.error(CommonResponseEnum.SERVER_ERROR.getCode(), e.getMessage());
	}
	
}
