package com.github.webapp.backend.common.exception;

import com.github.webapp.backend.common.enums.ResponseCode;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:35
 */
public class MethodNotAllowException extends BusinessException {
    private static final long serialVersionUID = -1947043530984504246L;

    public MethodNotAllowException() {
        super();
    }

    public MethodNotAllowException(Object data) {
        super.data = data;
    }

    public MethodNotAllowException(ResponseCode responseCode) {
        super(responseCode);
    }

    public MethodNotAllowException(ResponseCode responseCode, Object data) {
        super(responseCode, data);
    }

    public MethodNotAllowException(String msg) {
        super(msg);
    }

    public MethodNotAllowException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
