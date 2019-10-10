package com.github.webapp.backend.common.exception;

import com.github.webapp.backend.common.enums.ResponseCode;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:35
 */
public class ParameterInvalidException extends BusinessException {
    private static final long serialVersionUID = -6763391916038157647L;

    public ParameterInvalidException() {
        super();
    }

    public ParameterInvalidException(Object data) {
        super();
        super.data = data;
    }

    public ParameterInvalidException(ResponseCode responseCode) {
        super(responseCode);
    }

    public ParameterInvalidException(ResponseCode responseCode, Object data) {
        super(responseCode, data);
    }

    public ParameterInvalidException(String msg) {
        super(msg);
    }

    public ParameterInvalidException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
