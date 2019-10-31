package com.github.webapp.backend.log.factory;

import com.github.webapp.backend.common.auth.util.SpringContextHolder;
import com.github.webapp.backend.common.constant.LogSucceed;
import com.github.webapp.backend.common.constant.LogType;
import com.github.webapp.backend.common.util.StringUtil;
import com.github.webapp.backend.sys.entity.SysLoginLog;
import com.github.webapp.backend.sys.entity.SysOperationLog;
import com.github.webapp.backend.sys.mapper.SysLoginLogMapper;
import com.github.webapp.backend.sys.mapper.SysOperationLogMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;

/**
 * 日志操作任务创建工厂
 *
 * @author wangweijiang
 * @since 2019-10-29 20:08
 */
@Slf4j
public class LogTaskFactory {

    private static SysLoginLogMapper loginLogMapper = SpringContextHolder.getBean(SysLoginLogMapper.class);
    private static SysOperationLogMapper operationLogMapper = SpringContextHolder.getBean(SysOperationLogMapper.class);

    public static TimerTask loginLog(final Long userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                try {
                    SysLoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    log.error("创建登录日志异常!", e);
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                SysLoginLog loginLog = LogFactory.createLoginLog(
                        LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    log.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(final Long userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                SysLoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null, ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    log.error("创建退出日志异常!", e);
                }
            }
        };
    }

    public static TimerTask bussinessLog(final Long userId, final String bussinessName, final String clazzName, final String methodName, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                SysOperationLog operationLog = LogFactory.createSysOperationLog(
                        LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    log.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask exceptionLog(final Long userId, final Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                String msg = StringUtil.getExceptionMsg(exception);
                SysOperationLog operationLog = LogFactory.createSysOperationLog(
                        LogType.EXCEPTION, userId, "", null, null, msg, LogSucceed.FAIL);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    log.error("创建异常日志异常!", e);
                }
            }
        };
    }
}
