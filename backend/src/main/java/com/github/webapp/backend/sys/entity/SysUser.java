package com.github.webapp.backend.sys.entity;

import com.github.webapp.backend.common.model.po.BasePO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-10 18:39
 */
@Data
@Table
public class SysUser extends BasePO<Long> {
    private static final long serialVersionUID = 4413591646679580094L;
    /**
     * 主键
     */
    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 随机盐值
     */
    private String salt;

    /**
     * 名字
     */
    private String name;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 角色ID，多个ID用逗号分隔
     */
    private String roleId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 状态(字典)
     */
    private String status;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 乐观锁
     */
    private Integer version;
}
