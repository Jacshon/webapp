package com.github.webapp.backend.common.response;

import com.github.webapp.backend.common.enums.BusinessExceptionEnum;
import com.github.webapp.backend.common.enums.ResponseCode;
import com.github.webapp.backend.common.exception.BusinessException;
import com.github.webapp.backend.common.util.RequestContextHolderUtil;
import com.github.webapp.backend.common.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author wangweijiang
 * @since 2019-10-08 19:59
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DefaultErrorResponse implements Response{
    private static final long serialVersionUID = 1191869460456228061L;
    /**
     * HTTP响应状态码 {@link org.springframework.http.HttpStatus}
     */
    private Integer status;

    /**
     * HTTP响应状态码的英文提示
     */
    private String error;

    /**
     * 异常堆栈的精简信息
     *
     */
    private String message;

    /**
     * 自定义的返回值编码，{@link ResponseCode} 它是对错误更加详细的编码
     *
     * 备注：spring boot默认返回异常时，该字段为null
     */
    private Integer code;

    /**
     * 调用接口路径
     */
    private String path;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 异常的错误传递的数据
     */
    private Object errors;

    /**
     * 时间戳
     */
    private Date timestamp;

    public static DefaultErrorResponse failure(ResponseCode responseCode, Throwable e, HttpStatus httpStatus, Object errors) {
        DefaultErrorResponse result = DefaultErrorResponse.failure(responseCode, e, httpStatus);
        result.setErrors(errors);
        return result;
    }

    public static DefaultErrorResponse failure(ResponseCode responseCode, Throwable e, HttpStatus httpStatus) {
        DefaultErrorResponse result = new DefaultErrorResponse();
        result.setCode(responseCode.getCode());
        result.setMessage(responseCode.getMessage());
        result.setStatus(httpStatus.value());
        result.setError(httpStatus.getReasonPhrase());
        result.setException(e.getClass().getName());
        result.setPath(RequestContextHolderUtil.getRequest().getRequestURI());
        result.setTimestamp(new Date());
        return result;
    }

    public static DefaultErrorResponse failure(BusinessException e) {
        BusinessExceptionEnum ee = BusinessExceptionEnum.getByEClass(e.getClass());
        if (ee != null) {
            return DefaultErrorResponse.failure(ee.getResponseCode(), e, ee.getHttpStatus(), e.getData());
        }

        DefaultErrorResponse defaultErrorResponse = DefaultErrorResponse.failure(e.getResponseCode() == null ? ResponseCode.SUCCESS : e.getResponseCode(), e, HttpStatus.OK, e.getData());
        if (StringUtil.isNotEmpty(e.getMessage())) {
            defaultErrorResponse.setMessage(e.getMessage());
        }
        return defaultErrorResponse;
    }
}
