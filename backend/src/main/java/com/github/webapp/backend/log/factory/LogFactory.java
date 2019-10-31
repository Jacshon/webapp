package com.github.webapp.backend.log.factory;

import com.github.webapp.backend.common.constant.LogSucceed;
import com.github.webapp.backend.common.constant.LogType;
import com.github.webapp.backend.sys.entity.SysLoginLog;
import com.github.webapp.backend.sys.entity.SysOperationLog;

import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-29 19:47
 */
public class LogFactory {
    /**
     * 创建操作日志
     */
    public static SysOperationLog createSysOperationLog(LogType logType, Long userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
        SysOperationLog operationLog = new SysOperationLog();
        operationLog.setLogType(logType.getMessage());
        operationLog.setLogName(bussinessName);
        operationLog.setUserId(userId);
        operationLog.setClassName(clazzName);
        operationLog.setMethod(methodName);
        operationLog.setCreateTime(new Date());
        operationLog.setSucceed(succeed.getMessage());
        operationLog.setMessage(msg);
        return operationLog;
    }

    /**
     * 创建登录日志
     */
    public static SysLoginLog createLoginLog(LogType logType, Long userId, String msg, String ip) {
        SysLoginLog loginLog = new SysLoginLog();
        loginLog.setLogName(logType.getMessage());
        loginLog.setUserId(userId);
        loginLog.setCreateTime(new Date());
        loginLog.setSucceed(LogSucceed.SUCCESS.getMessage());
        loginLog.setIpAddress(ip);
        loginLog.setMessage(msg);
        return loginLog;
    }
}
