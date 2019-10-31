package com.github.webapp.backend.common.auth.context;

import com.github.webapp.backend.common.auth.util.SpringContextHolder;

/**
 * @author wangweijiang
 * @since 2019-10-29 12:07
 */
public class LoginContextHolder {
    public static LoginContext getContext() {
        return SpringContextHolder.getBean(LoginContext.class);
    }
}
