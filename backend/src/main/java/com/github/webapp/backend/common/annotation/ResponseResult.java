package com.github.webapp.backend.common.annotation;

import com.github.webapp.backend.common.response.Response;
import com.github.webapp.backend.common.response.ServerResponse;

import java.lang.annotation.*;

/**
 * @author wangweijiang
 * @since 2019-10-09 09:04
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseResult {
    Class<? extends Response>  value() default ServerResponse.class;
}
