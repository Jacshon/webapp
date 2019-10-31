package com.github.webapp.backend.sys.entity;

import com.github.webapp.backend.common.model.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:28
 */
@Data
public class SysRelation extends BasePO<Long> {
    private static final long serialVersionUID = -3788377933801871784L;
    /**
     * 主键
     */
    @Id
    @Column(name = "relation_id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private Long roleId;

    private Long menuId;
}
