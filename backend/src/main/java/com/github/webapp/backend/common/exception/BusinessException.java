package com.github.webapp.backend.common.exception;

import com.github.webapp.backend.common.enums.BusinessExceptionEnum;
import com.github.webapp.backend.common.enums.ResponseCode;
import com.github.webapp.backend.common.util.StringUtil;
import lombok.Data;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:24
 */
@Data
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 466590015163688409L;
    protected String code;

    protected String message;

    protected ResponseCode responseCode;

    protected Object data;

    public BusinessException() {
        BusinessExceptionEnum exceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            responseCode = exceptionEnum.getResponseCode();
            code = exceptionEnum.getResponseCode().code().toString();
            message = exceptionEnum.getResponseCode().message();
        }

    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        this.message = StringUtil.formatIfArgs(format, "{}", objects);
    }

    public BusinessException(ResponseCode responseCode, Object data) {
        this(responseCode);
        this.data = data;
    }

    public BusinessException(ResponseCode responseCode) {
        this.responseCode = responseCode;
        this.code = responseCode.code().toString();
        this.message = responseCode.message();
    }
}
