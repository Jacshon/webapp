package com.github.webapp.backend.common.exception;

import com.github.webapp.backend.common.enums.ResponseCode;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:37
 */
public class RemoteAccessException extends BusinessException {
    private static final long serialVersionUID = -3719701682353512236L;

    public RemoteAccessException() {
        super();
    }

    public RemoteAccessException(Object data) {
        super.data = data;
    }

    public RemoteAccessException(ResponseCode responseCode) {
        super(responseCode);
    }

    public RemoteAccessException(ResponseCode responseCode, Object data) {
        super(responseCode, data);
    }

    public RemoteAccessException(String msg) {
        super(msg);
    }

    public RemoteAccessException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
