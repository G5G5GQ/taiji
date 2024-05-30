package com.mall.common.exception;

import com.mall.common.result.IErrorCode;
import lombok.Getter;

/**
 * 业务异常
 * @author
 */
@Getter
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public IErrorCode errorCode;

    public BizException(IErrorCode iErrorCode) {
        super(iErrorCode.msg());
        this.errorCode = iErrorCode;
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }
}
