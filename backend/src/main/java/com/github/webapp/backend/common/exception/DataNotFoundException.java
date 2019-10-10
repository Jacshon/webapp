package com.github.webapp.backend.common.exception;

import com.github.webapp.backend.common.enums.ResponseCode;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:34
 */
public class DataNotFoundException extends BusinessException {
    private static final long serialVersionUID = -2193531352790017724L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(Object data) {
        super();
        super.data = data;
    }

    public DataNotFoundException(ResponseCode responseCode) {
        super(responseCode);
    }

    public DataNotFoundException(ResponseCode responseCode, Object data) {
        super(responseCode, data);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public DataNotFoundException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
