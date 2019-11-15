package com.github.webapp.backend.sys.service.impl;

import com.github.webapp.backend.common.service.impl.BaseMySqlCrudServiceImpl;
import com.github.webapp.backend.sys.entity.SysMenu;
import com.github.webapp.backend.sys.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * @author wangweijiang
 * @since 2019-10-31 21:27
 */
@Service
public class SysMenuServiceImpl extends BaseMySqlCrudServiceImpl<SysMenu, Long> implements SysMenuService {
}
