package com.github.webapp.backend.common.service;

/**
 * @author wangweijiang
 * @since 2019-10-14 14:57
 */
public interface InsertService<E, PK> {
    /**
     * 添加一条数据
     *
     * @param record 要添加的数据
     * @return 添加后生成的主键
     */
    PK insert(E record);
}
