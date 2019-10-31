package com.github.webapp.backend.common.model.po;

import lombok.Data;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:13
 */
public interface TreePO<PK> extends PO<PK> {
    PK getParentId();

    void setParentId(PK parentId);
}
