package com.github.webapp.backend.sys.mapper;

import com.github.webapp.backend.common.dao.CrudMapper;
import com.github.webapp.backend.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangweijiang
 * @since 2019-10-27 14:20
 */
@Mapper
public interface SysUserMapper extends CrudMapper<SysUser> {
}
