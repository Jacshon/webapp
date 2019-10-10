package com.github.webapp.backend.common.exception;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:38
 */
public class UserNotLoginException extends BusinessException {
    private static final long serialVersionUID = -6796499583928475682L;

    public UserNotLoginException() {
        super();
    }

    public UserNotLoginException(String msg) {
        super(msg);
    }

    public UserNotLoginException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
