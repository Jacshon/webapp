package com.github.webapp.backend.sys.service.impl;

import com.github.webapp.backend.common.service.impl.BaseMySqlCrudServiceImpl;
import com.github.webapp.backend.sys.entity.SysUser;
import com.github.webapp.backend.sys.mapper.SysUserMapper;
import com.github.webapp.backend.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangweijiang
 * @since 2019-10-27 14:21
 */
@Service
public class SysUserServiceImpl extends BaseMySqlCrudServiceImpl<SysUser, Long> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByAccount(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setAccount(username);
        return sysUserMapper.selectOne(sysUser);
    }
}
