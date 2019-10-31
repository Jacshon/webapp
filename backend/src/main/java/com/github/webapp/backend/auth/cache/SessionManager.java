package com.github.webapp.backend.auth.cache;

import com.github.webapp.backend.common.auth.model.LoginUser;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:19
 */
public interface SessionManager {
    /**
     * 缓存前缀
     */
    String SESSION_PREFIX = "LOGIN_USER_";

    /**
     * 创建会话
     *
     * @author fengshuonan
     * @Date 2019-09-28 14:50
     */
    void createSession(String token, LoginUser loginUser);

    /**
     * 获取会话
     *
     * @author fengshuonan
     * @Date 2019-09-28 14:50
     */
    LoginUser getSession(String token);

    /**
     * 删除会话
     *
     * @author fengshuonan
     * @Date 2019-09-28 14:50
     */
    void removeSession(String token);

    /**
     * 是否已经登陆
     *
     * @author fengshuonan
     * @Date 2019-09-28 14:56
     */
    boolean haveSession(String token);
}
