package com.github.webapp.backend.sys.entity;

import com.github.webapp.backend.common.model.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-29 19:55
 */
@Data
public class SysLoginLog extends BasePO<Long> {
    private static final long serialVersionUID = 6841469958515087767L;
    /**
     * 主键
     */
    @Id
    @Column(name = "login_log_id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 日志名称
     */
    private String logName;

    /**
     * 管理员id
     */
    private Long userId;

    /**
     * 是否执行成功
     */
    private String succeed;

    /**
     * 具体消息
     */
    private String message;

    /**
     * 登录ip
     */
    private String ipAddress;
}
