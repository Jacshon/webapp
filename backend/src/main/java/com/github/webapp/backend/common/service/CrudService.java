package com.github.webapp.backend.common.service;

/**
 * @author wangweijiang
 * @since 2019-10-14 14:56
 */
public interface CrudService<E, PK> extends
        InsertService<E, PK>,
        UpdateService<E,PK>,
        DeleteService<PK>,
        SelectService<E, PK>  {
}
