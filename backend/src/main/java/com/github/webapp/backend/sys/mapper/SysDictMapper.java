package com.github.webapp.backend.sys.mapper;

import com.github.webapp.backend.common.dao.CrudMapper;
import com.github.webapp.backend.sys.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:54
 */
@Mapper
public interface SysDictMapper extends CrudMapper<SysDict> {
}
