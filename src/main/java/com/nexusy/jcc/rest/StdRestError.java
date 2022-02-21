package com.nexusy.jcc.rest;

/**
 * @author lanhuidong
 * @since 2022-02-21
 */
public enum StdRestError implements RestError {

    PARAMETER_ERROR(1000100, "参数错误"),
    OPERATE_TOO_FREQUENT(1000101, "操作太频繁"),
    NOT_LOGIN(1000200, "用户未登录"),
    NO_PERMISSIONS(1000201, "没有权限"),
    SIGNATURE_ERROR(1000202, "签名校验失败"),
    UNKNOWN_ERROR(1000700, "系统发生未知错误");

    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    StdRestError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\"code\":"+code+",\"message\":\""+message+"\"}";
    }
}
