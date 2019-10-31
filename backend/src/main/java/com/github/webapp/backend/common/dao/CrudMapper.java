package com.github.webapp.backend.common.dao;

/**
 * 基础增删改查功能mapper
 *
 * @author wangweijiang
 * @since 2019-10-10 18:02
 */
public interface CrudMapper<T> extends
        InsertMapper<T>,
        DeleteMapper<T>,
        UpdateMapper<T>,
        SelectMapper<T>{
}
