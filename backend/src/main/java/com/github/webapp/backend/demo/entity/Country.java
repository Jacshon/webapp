package com.github.webapp.backend.demo.entity;

import com.github.webapp.backend.common.model.po.BasePO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangweijiang
 * @since 2019-10-14 14:42
 */
@Getter
@Setter
@Table(name = "country")
public class Country extends BasePO<Integer> {
    private static final long serialVersionUID = -2606470508355617374L;
    /**
     * 主键
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 名称
     */
    private String countryname;

    /**
     * 代码
     */
    private String countrycode;

}
