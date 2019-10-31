package com.github.webapp.backend.sys.entity.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-31 21:22
 */
@Data
public class SysUserDto {
    private Long userId;
    private String account;
    private String password;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String sex;
    private String email;
    private String phone;
    private String roleId;
    private Long deptId;
    private String status;
    private String avatar;

    private String position;
}
