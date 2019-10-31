package com.github.webapp.backend.demo.controller;

import com.github.webapp.backend.common.annotation.ResponseResult;
import com.github.webapp.backend.common.response.ServerResponse;
import com.github.webapp.backend.demo.entity.Country;
import com.github.webapp.backend.demo.mapper.CountryMapper;
import com.github.webapp.backend.demo.service.CountryService;
import com.github.webapp.backend.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-09-26 16:26
 */
@ResponseResult
@Slf4j
//@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.CREATED)
    public Country demo() {
        log.info("hello world");
        Date currentDate = new Date();
        Country country = new Country();
        country.setCountrycode("zhongguo111");
        country.setCountryname("zhongguo111");
        country.setCreateTime(currentDate);
        country.setUpdateTime(currentDate);
        countryService.insert(country);
        return countryService.selectByPk(country.getId());
    }
}
