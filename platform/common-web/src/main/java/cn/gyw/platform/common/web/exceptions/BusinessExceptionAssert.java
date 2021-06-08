package cn.gyw.platform.common.web.exceptions;

import java.text.MessageFormat;

import cn.gyw.platform.common.web.IRespCode;

/**
 * 业务异常断言
 */
public interface BusinessExceptionAssert extends IRespCode, IExceptionAssert {

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
