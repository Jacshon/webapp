package com.github.webapp.backend.demo.service.impl;

import com.github.webapp.backend.common.service.impl.BaseMySqlCrudServiceImpl;
import com.github.webapp.backend.demo.entity.Country;
import com.github.webapp.backend.demo.service.CountryService;
import org.springframework.stereotype.Service;

/**
 * @author wangweijiang
 * @since 2019-10-14 15:38
 */
//@Service
public class CountryServiceImpl extends BaseMySqlCrudServiceImpl<Country, Integer> implements CountryService {
}
