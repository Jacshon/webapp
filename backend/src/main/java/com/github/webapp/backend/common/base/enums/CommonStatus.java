package com.github.webapp.backend.common.base.enums;

import lombok.Getter;

/**
 * @author wangweijiang
 * @since 2019-10-29 13:52
 */
@Getter
public enum CommonStatus {
    ENABLE("ENABLE", "启用"),
    DISABLE("DISABLE", "禁用");

    String code;
    String message;

    CommonStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getDescription(String status) {
        if (status == null) {
            return "";
        } else {
            for (CommonStatus s : CommonStatus.values()) {
                if (s.getCode().equals(status)) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
