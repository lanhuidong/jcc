package com.nexusy.jcc.rest;

/**
 * @author lanhuidong
 * @since 2022-02-21
 */
public class RestResponse<T> {

    private static final RestResponse<Void> SUCCESS = new RestResponse<>(0, "OK");

    private String traceId;
    private int code;
    private String message;
    private T data;

    public RestResponse() {
    }

    public RestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static RestResponse<Void> success() {
        return SUCCESS;
    }

    public static <T> RestResponse<T> success(T data) {
        RestResponse<T> baseResp = new RestResponse<>(0, "OK");
        baseResp.setData(data);
        return baseResp;
    }

    public static <T> RestResponse<T> failed(int code, String message) {
        return new RestResponse<>(code, message);
    }

    public static <T> RestResponse<T> failed(RestError error) {
        return new RestResponse<>(error.getCode(), error.getMessage());
    }

}
