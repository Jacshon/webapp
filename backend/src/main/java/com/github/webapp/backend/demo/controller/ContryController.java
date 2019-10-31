package com.github.webapp.backend.demo.controller;

import com.github.webapp.backend.common.annotation.ResponseResult;
import com.github.webapp.backend.common.model.qo.PageQO;
import com.github.webapp.backend.common.model.vo.PageVO;
import com.github.webapp.backend.demo.entity.Country;
import com.github.webapp.backend.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:49
 */
@ResponseResult
//@RestController
@RequestMapping("/contry")
public class ContryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public PageVO<Country> getList(PageQO pageQO) {
        return countryService.selectPage(pageQO);
    }

    @PostMapping("addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public Country addUser(@Validated @RequestBody Country country) {
        Date currentDate = new Date();
        country.setCreateTime(currentDate);
        country.setUpdateTime(currentDate);
        countryService.insert(country);
        return countryService.selectByPk(country.getId());
    }
}
