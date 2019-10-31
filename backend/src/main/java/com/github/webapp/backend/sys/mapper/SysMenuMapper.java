package com.github.webapp.backend.sys.mapper;

import com.github.webapp.backend.common.dao.CrudMapper;
import com.github.webapp.backend.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:53
 */
@Mapper
public interface SysMenuMapper extends CrudMapper<SysMenu> {
}
