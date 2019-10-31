package com.github.webapp.backend.sys.entity;

import com.github.webapp.backend.common.model.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-29 19:48
 */
@Data
public class SysOperationLog extends BasePO<Long> {
    private static final long serialVersionUID = -7343632474277776092L;

    /**
     * 主键
     */
    @Id
    @Column(name = "operation_log_id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 日志类型(字典)
     */
    private String logType;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 类名称
     */
    private String className;

    /**
     * 方法名称
     */
    private String method;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否成功(字典)
     */
    private String succeed;

    /**
     * 备注
     */
    private String message;
}
