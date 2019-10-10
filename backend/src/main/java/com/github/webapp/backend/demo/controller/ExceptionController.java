package com.github.webapp.backend.demo.controller;

import com.github.webapp.backend.common.annotation.ResponseResult;
import com.github.webapp.backend.common.exception.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangweijiang
 * @since 2019-10-09 10:17
 */
@RestController
@RequestMapping("/exception")
@ResponseResult
public class ExceptionController {

    @GetMapping("/dataConflict")
    public void dataConflictException () {
        throw new DataConflictException();
    }

    @GetMapping("/dataNotFount")
    public void dataNotFountException () {
        throw new DataNotFoundException();
    }

    @GetMapping("/methodNotAllow")
    public void methodNotAllowException () {
        throw new MethodNotAllowException();
    }

    @GetMapping("/internalServer")
    public void internalServerException () {
        throw new InternalServerException();
    }

    @GetMapping("/parameterInvalid")
    public void parameterInvalidException () {
        throw new ParameterInvalidException();
    }

    @GetMapping("/permissionForbidden")
    public void permissionForbiddenException () {
        throw new PermissionForbiddenException();
    }

    @GetMapping("/remoteAccess")
    public void remoteAccessException () {
        throw new RemoteAccessException();
    }

    @GetMapping("/userNotLogin")
    public void userNotLoginException () {
        throw new UserNotLoginException();
    }
}
