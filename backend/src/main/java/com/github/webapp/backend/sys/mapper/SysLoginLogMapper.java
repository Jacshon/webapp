package com.github.webapp.backend.sys.mapper;

import com.github.webapp.backend.common.dao.CrudMapper;
import com.github.webapp.backend.sys.entity.SysLoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangweijiang
 * @since 2019-10-29 20:39
 */
@Mapper
public interface SysLoginLogMapper  extends CrudMapper<SysLoginLog> {
}
