package com.github.webapp.backend.common.model.po;

import com.github.webapp.backend.common.model.Model;

import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:03
 */
public interface PO<PK> extends Model {
    PK getId();

    void setId(PK id);

    Date getCreateTime();

    void setCreateTime(Date createTime);

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);
}
