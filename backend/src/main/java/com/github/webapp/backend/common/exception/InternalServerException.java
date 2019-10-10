package com.github.webapp.backend.common.exception;

/**
 * @author wangweijiang
 * @since 2019-10-08 20:35
 */
public class InternalServerException extends BusinessException {
    private static final long serialVersionUID = 7097051623274822450L;

    public InternalServerException() {
        super();
    }

    public InternalServerException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InternalServerException(String msg, Throwable cause, Object... objects) {
        super(msg, cause, objects);
    }

    public InternalServerException(String msg) {
        super(msg);
    }

    public InternalServerException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}
