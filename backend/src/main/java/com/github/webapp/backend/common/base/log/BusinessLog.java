package com.github.webapp.backend.common.base.log;

import java.lang.annotation.*;

/**
 * @author wangweijiang
 * @since 2019-10-29 20:01
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface BusinessLog {
    /**
     * 业务的名称,例如:"修改菜单"
     */
    String value() default "";

    /**
     * 被修改的实体的唯一标识,例如:菜单实体的唯一标识为"id"
     */
    String key() default "id";

//    /**
//     * 字典(用于查找key的中文名称和字段的中文名称)
//     */
//    Class<? extends AbstractDictMap> dict() default SystemDict.class;
}
