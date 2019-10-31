package com.github.webapp.backend.common.constant;

/**
 * 业务是否成功的日志记录
 *
 * @author wangweijiang
 * @since 2019-10-29 19:55
 */
public enum LogSucceed {
    SUCCESS("成功"),
    FAIL("失败");

    String message;

    LogSucceed(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
