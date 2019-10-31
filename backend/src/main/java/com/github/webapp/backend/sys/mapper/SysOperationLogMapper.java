package com.github.webapp.backend.sys.mapper;

import com.github.webapp.backend.common.dao.CrudMapper;
import com.github.webapp.backend.sys.entity.SysOperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangweijiang
 * @since 2019-10-29 20:40
 */
@Mapper
public interface SysOperationLogMapper extends CrudMapper<SysOperationLog> {
}
