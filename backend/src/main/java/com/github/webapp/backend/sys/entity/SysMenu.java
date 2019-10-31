package com.github.webapp.backend.sys.entity;

import com.github.webapp.backend.common.model.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wangweijiang
 * @since 2019-10-29 14:27
 */
@Data
public class SysMenu  extends BasePO<Long> {
    private static final long serialVersionUID = 3543590256921117125L;
    /**
     * 主键
     */
    @Id
    @Column(name = "menu_id")
    @GeneratedValue(generator = "JDBC")
    private Long id;
}
