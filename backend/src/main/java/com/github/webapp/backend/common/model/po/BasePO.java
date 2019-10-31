package com.github.webapp.backend.common.model.po;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:12
 */
@Data
public abstract class BasePO<PK> implements PO<PK> {
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
