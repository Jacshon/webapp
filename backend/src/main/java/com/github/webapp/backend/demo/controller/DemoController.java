package com.github.webapp.backend.demo.controller;

import com.github.webapp.backend.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangweijiang
 * @since 2019-09-26 16:26
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.CREATED)
    public String demo() {
        demoService.queryDB();
        return "hello world";
    }
}