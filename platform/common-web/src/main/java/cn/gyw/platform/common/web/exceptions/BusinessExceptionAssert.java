package cn.gyw.platform.common.web.exceptions;

import cn.gyw.platform.common.web.enums.IResponseEnum;

import java.text.MessageFormat;

/**
 * 业务异常断言
 */
public interface BusinessExceptionAssert extends IResponseEnum, ExceptionAssert {

    @Override
    default BaseException newException(Object... args) {
        String message = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, message);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String message = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, message, t);
    }
}
