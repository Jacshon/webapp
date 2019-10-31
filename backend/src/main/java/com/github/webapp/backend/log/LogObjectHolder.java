package com.github.webapp.backend.log;

import com.github.webapp.backend.common.auth.util.SpringContextHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/**
 * 被修改的bean临时存放的地方
 *
 * @author wangweijiang
 * @since 2019-10-29 19:43
 */
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class LogObjectHolder implements Serializable {
    private static final long serialVersionUID = 4626628621479607L;
    private Object object = null;

    public void set(Object obj) {
        this.object = obj;
    }

    public Object get() {
        return object;
    }

    public static LogObjectHolder me() {
        return SpringContextHolder.getBean(LogObjectHolder.class);
    }
}
