/*
 * Created on 2015-09-14 16:21:00
 *
 */
package com.luyi.user.common;

import lombok.Data;

/**
 * @Author: luyi
 * @Description: 响应返回实体类
 * @Date: Created in 2022-05-18
 */
@Data
public class ResponseData<T> {
    private int code;
    private String message;
    private T data;

    public ResponseData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseData<T> success() {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static <T> ResponseData<T> success(String message) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), message, null);
    }

    public static <T> ResponseData<T> success(T data) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), null, data);
    }

    public static <T> ResponseData<T> success(String message, T data) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseData<T> error() {
        return new ResponseData(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage(), null);
    }

    public static <T> ResponseData<T> error(String message) {
        return new ResponseData(ResponseCode.ERROR.getCode(), message, null);
    }

    public static <T> ResponseData<T> error(String message, T data) {
        return new ResponseData(ResponseCode.ERROR.getCode(), message, data);
    }
}