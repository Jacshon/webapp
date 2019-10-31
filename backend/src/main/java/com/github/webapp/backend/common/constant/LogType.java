package com.github.webapp.backend.common.constant;

/**
 * 日志类型
 *
 * @author wangweijiang
 * @since 2019-10-29 19:54
 */
public enum LogType {
    LOGIN("登录日志"),
    LOGIN_FAIL("登录失败日志"),
    EXIT("退出日志"),
    EXCEPTION("异常日志"),
    BUSSINESS("业务日志");

    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
