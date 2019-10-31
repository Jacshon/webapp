package com.github.webapp.backend.sys.controller;

import com.github.webapp.backend.common.annotation.ResponseResult;
import com.github.webapp.backend.sys.entity.SysUser;
import com.github.webapp.backend.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangweijiang
 * @since 2019-10-27 14:23
 */
@ResponseResult
@RestController
@RequestMapping("/sysUser/")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> getUserList() {
        return sysUserService.selectAll();
    }
}
