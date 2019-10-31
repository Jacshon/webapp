package com.github.webapp.backend.log.aop;

import com.github.webapp.backend.common.auth.context.LoginContextHolder;
import com.github.webapp.backend.common.auth.model.LoginUser;
import com.github.webapp.backend.common.util.RequestContextUtil;
import com.github.webapp.backend.log.LogManager;
import com.github.webapp.backend.log.LogObjectHolder;
import com.github.webapp.backend.log.factory.LogTaskFactory;
import com.github.webapp.backend.common.base.log.BusinessLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author wangweijiang
 * @since 2019-10-29 19:45
 */
@Slf4j
@Aspect
@Component
public class LogAop {

    @Pointcut(value = "@annotation(com.github.webapp.backend.common.base.log.BusinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {

        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();

        //如果当前用户未登录，不做日志
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (null == user) {
            return;
        }

        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();

        //获取操作名称
        BusinessLog annotation = currentMethod.getAnnotation(BusinessLog.class);
        String bussinessName = annotation.value();
        String key = annotation.key();

        StringBuilder sb = new StringBuilder();
        for (Object param : params) {
            sb.append(param);
            sb.append(" & ");
        }

        //如果涉及到修改,比对变化
        String msg = "";
        if (bussinessName.contains("修改") || bussinessName.contains("编辑")) {
            Object obj1 = LogObjectHolder.me().get();
            Map<String, String> obj2 = RequestContextUtil.getRequestParameters();
        } else {
            Map<String, String> parameters = RequestContextUtil.getRequestParameters();
        }

        LogManager.me().executeLog(LogTaskFactory.bussinessLog(user.getId(), bussinessName, className, methodName, msg));
    }
}
