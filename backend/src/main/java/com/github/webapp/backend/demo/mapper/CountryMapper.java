package com.github.webapp.backend.demo.mapper;

import com.github.webapp.backend.common.dao.CrudMapper;
import com.github.webapp.backend.demo.entity.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountryMapper extends CrudMapper<Country> {
}
