package com.github.webapp.backend.auth.cache.impl;

import com.github.webapp.backend.common.auth.model.LoginUser;
import com.github.webapp.backend.auth.cache.SessionManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:24
 */
public class DefaultSessionManager implements SessionManager {

    private Map<String, LoginUser> caches = new ConcurrentHashMap<>();

    @Override
    public void createSession(String token, LoginUser loginUser) {
        caches.put(SESSION_PREFIX + token, loginUser);
    }

    @Override
    public LoginUser getSession(String token) {
        return caches.get(SESSION_PREFIX + token);
    }

    @Override
    public void removeSession(String token) {
        caches.remove(SESSION_PREFIX + token);
    }

    @Override
    public boolean haveSession(String token) {
        return caches.containsKey(SESSION_PREFIX + token);
    }
}
