package com.github.webapp.backend.common.dao;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * 基础新增功能Mapper
 *
 * @author wangweijiang
 * @since 2019-10-10 17:59
 */
public interface InsertMapper<T> extends Marker,
        tk.mybatis.mapper.common.base.insert.InsertMapper<T>,
        InsertSelectiveMapper<T>,
        MySqlMapper<T> {
}
