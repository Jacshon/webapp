package com.github.webapp.backend.sys.entity;

import com.github.webapp.backend.common.model.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:32
 */
@Data
@Table
public class SysDict  extends BasePO<Long> {
    private static final long serialVersionUID = 2218937061426189179L;
    /**
     * 主键
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Long id;
}
