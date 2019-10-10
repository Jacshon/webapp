package com.github.webapp.backend.common.exception;

import com.github.webapp.backend.common.enums.ResponseCode;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:36
 */
public class PermissionForbiddenException extends BusinessException {
    private static final long serialVersionUID = -923477276605642731L;

    public PermissionForbiddenException() {
        super();
    }

    public PermissionForbiddenException(Object data) {
        super.data = data;
    }

    public PermissionForbiddenException(ResponseCode responseCode) {
        super(responseCode);
    }

    public PermissionForbiddenException(ResponseCode responseCode, Object data) {
        super(responseCode, data);
    }

    public PermissionForbiddenException(String msg) {
        super(msg);
    }

    public PermissionForbiddenException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
