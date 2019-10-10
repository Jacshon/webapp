package com.github.webapp.backend.common.response;

import com.github.webapp.backend.common.enums.ResponseCode;
import lombok.*;

/**
 * 正常返回结果
 *
 * @author wangweijiang
 * @since 2019-10-08 15:08
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ServerResponse implements Response {
    private static final long serialVersionUID = -3055239950585006203L;

    private Object data;
    private Integer code;
    private String msg;

    public static ServerResponse success() {
        ServerResponse result = new ServerResponse();
        result.setResultCode(ResponseCode.SUCCESS);
        return result;
    }

    public static ServerResponse success(Object data) {
        ServerResponse result = new ServerResponse();
        result.setResultCode(ResponseCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static ServerResponse failure(ResponseCode resultCode) {
        ServerResponse result = new ServerResponse();
        result.setResultCode(resultCode);
        return result;
    }

    public static ServerResponse failure(ResponseCode resultCode, Object data) {
        ServerResponse result = new ServerResponse();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static ServerResponse failure(String message) {
        ServerResponse result = new ServerResponse();
        result.setCode(ResponseCode.PARAM_IS_INVALID.getCode());
        result.setMsg(message);
        return result;
    }

    private void setResultCode(ResponseCode code) {
        this.code = code.getCode();
        this.msg = code.getMessage();
    }
}
