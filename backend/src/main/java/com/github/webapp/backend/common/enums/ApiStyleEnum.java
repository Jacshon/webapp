package com.github.webapp.backend.common.enums;

/**
 * @author wangweijiang
 * @since 2019-10-09 09:47
 */
public enum ApiStyleEnum {
    NONE;

    public static boolean isValid(String name) {
        for (ApiStyleEnum callSource : ApiStyleEnum.values()) {
            if (callSource.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
