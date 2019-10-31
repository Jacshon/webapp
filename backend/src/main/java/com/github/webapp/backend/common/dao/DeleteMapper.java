package com.github.webapp.backend.common.dao;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.delete.DeleteByPrimaryKeyMapper;
import tk.mybatis.mapper.common.condition.DeleteByConditionMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

/**
 * 基础删除功能Mapper
 *
 * @author wangweijiang
 * @since 2019-10-09 11:33
 */
public interface DeleteMapper<T> extends Marker,
        tk.mybatis.mapper.common.base.delete.DeleteMapper<T>,
        DeleteByPrimaryKeyMapper<T>,
        DeleteByConditionMapper<T>,
        DeleteByIdsMapper<T> {
}
