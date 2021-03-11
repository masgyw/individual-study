package cn.gyw.components.web.external;

import org.springframework.stereotype.Component;

/**
 * 统一信息处理
 */
@Component
public class UnifiedMessageSource {

	public String getMessage(String code, Object[] args) {
		StringBuilder builder = new StringBuilder(code);
		for (Object arg : args) {
			builder.append(",").append(arg);
		}
		return builder.toString();
	}
}
