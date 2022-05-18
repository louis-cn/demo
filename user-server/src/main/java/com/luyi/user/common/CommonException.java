package com.luyi.user.common;

import lombok.Data;

/**
 * @Author: luyi
 * @Description: 公共异常类
 * @Date: Created in 2022-05-18
 */
@Data
public class CommonException extends RuntimeException {
    private Exception exception;
    private String msg;
    private Object object;

    public CommonException(String msg, Exception exception, Object object) {
        this.exception = exception;
        this.msg = msg;
        this.object = object;
    }

    public CommonException(String msg, Exception exception) {
        this.exception = exception;
        this.msg = msg;
    }

    public CommonException(String msg) {
        this.msg = msg;
    }
}
