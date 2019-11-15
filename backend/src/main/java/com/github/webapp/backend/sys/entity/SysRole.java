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
public class SysRole extends BasePO<Long> {
    private static final long serialVersionUID = 6254187050482059969L;
    /**
     * 主键
     */
    @Id
    @Column(name = "role_id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String name;

}
