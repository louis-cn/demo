package com.luyi.user.common;

/**
 * @Author: luyi
 * @Description: 返回实体类
 * @Date: Created in 2022-05-18
 */
public enum ResponseCode {
    SUCCESS(200, "请求成功"),
    ERROR(500, "内部错误"),
    PARAM_ERROR(400, "请求参数错误");

    private int code;
    private String message;

    private ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}