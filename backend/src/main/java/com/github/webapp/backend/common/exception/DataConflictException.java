package com.github.webapp.backend.common.exception;

import com.github.webapp.backend.common.enums.ResponseCode;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:34
 */
public class DataConflictException extends BusinessException {
    private static final long serialVersionUID = 6140772333102113181L;

    public DataConflictException() {
        super();
    }

    public DataConflictException(Object data) {
        super.data = data;
    }

    public DataConflictException(ResponseCode responseCode) {
        super(responseCode);
    }

    public DataConflictException(ResponseCode responseCode, Object data) {
        super(responseCode, data);
    }

    public DataConflictException(String msg) {
        super(msg);
    }

    public DataConflictException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
