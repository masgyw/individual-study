package cn.gyw.platform.common.web.exceptions;

/**
 * 异常断言
 */
public interface IExceptionAssert {
	
	BaseException newException(Object... args);

	BaseException newException(Throwable t, Object... args);

	default void assertNotNull(Object obj) {
		if (obj == null) {
			throw newException(obj);
		}
	}

	/**
	 *
	 * @param obj 异常对象
	 * @param args 异常信息
	 * @throws BaseException
	 */
	default void assertNotNull(Object obj, Object... args) {
		if (obj == null) {
			throw newException(args);
		}
	}
}
