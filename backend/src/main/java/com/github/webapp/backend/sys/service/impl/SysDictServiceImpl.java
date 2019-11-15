package com.github.webapp.backend.sys.service.impl;

import com.github.webapp.backend.common.service.impl.BaseMySqlCrudServiceImpl;
import com.github.webapp.backend.sys.entity.SysDict;
import com.github.webapp.backend.sys.service.SysDictService;
import org.springframework.stereotype.Service;

/**
 * @author wangweijiang
 * @since 2019-10-31 21:33
 */
@Service
public class SysDictServiceImpl extends BaseMySqlCrudServiceImpl<SysDict, Long> implements SysDictService {
}
