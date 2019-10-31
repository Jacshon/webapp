package com.github.webapp.backend.sys.service;

import com.github.webapp.backend.common.service.CrudService;
import com.github.webapp.backend.sys.entity.SysUser;

/**
 * @author wangweijiang
 * @since 2019-10-27 14:21
 */
public interface SysUserService extends CrudService<SysUser, Long> {
    /**
     * 根据账号获取账号信息
     *
     * @param username 账号名称
     * @return 账号名称对应账号信息
     */
    SysUser getByAccount(String username);
}
