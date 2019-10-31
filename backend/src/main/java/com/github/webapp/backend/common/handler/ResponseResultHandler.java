package com.github.webapp.backend.common.handler;

import com.github.webapp.backend.common.annotation.ResponseResult;
import com.github.webapp.backend.common.constant.HeaderConstants;
import com.github.webapp.backend.common.enums.ApiStyleEnum;
import com.github.webapp.backend.common.interceptor.ResponseResultInterceptor;
import com.github.webapp.backend.common.response.DefaultErrorResponse;
import com.github.webapp.backend.common.response.Response;
import com.github.webapp.backend.common.response.ServerResponse;
import com.github.webapp.backend.common.util.JsonUtil;
import com.github.webapp.backend.common.util.RequestContextUtil;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangweijiang
 * @since 2019-10-09 09:32
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        HttpServletRequest request = RequestContextUtil.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        return responseResultAnn != null && !ApiStyleEnum.NONE.name().equalsIgnoreCase(request.getHeader(HeaderConstants.API_STYLE));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ResponseResult responseResultAnn = (ResponseResult) RequestContextUtil.getRequest().getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        Class<? extends Response> resultClazz = responseResultAnn.value();
        if (resultClazz.isAssignableFrom(ServerResponse.class)) {
            if (body instanceof DefaultErrorResponse) {
                DefaultErrorResponse defaultErrorResponse = (DefaultErrorResponse) body;
                return ServerResponse.builder()
                        .code(defaultErrorResponse.getCode())
                        .msg(defaultErrorResponse.getMessage())
                        .data(defaultErrorResponse.getErrors())
                        .build();
            } else if (body instanceof String) {
                return JsonUtil.object2Json(ServerResponse.success(body));
            }

            return ServerResponse.success(body);
        }

        return body;
    }
}
