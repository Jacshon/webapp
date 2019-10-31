package com.github.webapp.backend.common.auth.service;

import com.github.webapp.backend.common.auth.model.LoginUser;

import java.util.List;

/**
 * Auth相关数据库的操作
 *
 * @author wangweijiang
 * @since 2019-10-29 11:37
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param username 账号
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     * 登录（直接用账号登录）
     *
     * @param username 账号
     * @return token
     */
    String login(String username);

    /**
     * 创建登录cookie
     * @param token token
     */
    void addLoginCookie(String token);

    /**
     * 退出当前用户
     */
    void logout();

    /**
     * 退出
     *
     * @param token token
     */
    void logout(String token);

    /**
     * 根据账号获取登录用户
     *
     * @param account 账号
     */
    LoginUser user(String account);

    /**
     * 通过角色id获取权限列表
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    List<String> findPermissionsByRoleId(Long roleId);

    /**
     * 检查当前登录用户是否拥有指定的角色访问当
     *
     * @param roleNames 角色名称集合
     * @return 是否具有权限
     */
    boolean check(String[] roleNames);

    /**
     * 检查当前登录用户是否拥有当前请求的servlet的权限
     * @return 是否具有权限
     */
    boolean checkAll();
}
