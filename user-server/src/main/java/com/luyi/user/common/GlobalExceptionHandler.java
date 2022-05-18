package com.luyi.user.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

/**
 * @Author: luyi
 * @Description: 全局异常处理
 * @Date: Created in 2022-05-18
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String EXCEPTION_MESSAGE = "系统内部异常，请联系管理员";

    @ExceptionHandler(RuntimeException.class)
    public ResponseData handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        log.error("运行时异常处理【url {}, msg {}】", request.getRequestURL(), e.getMessage());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("url", request.getRequestURL());
        if (e != null) {
            resultMap.put("errorMessage", e.getMessage());
        }
        return ResponseData.error(EXCEPTION_MESSAGE, resultMap);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseData handleException(Exception e, HttpServletRequest request) {
        log.error("统一异常处理【url {}, msg {}】", request.getRequestURL(), e.getMessage());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("url", request.getRequestURL());
        if (e != null) {
            resultMap.put("errorMessage", e.getMessage());
        }
        return ResponseData.error(EXCEPTION_MESSAGE, resultMap);
    }

    @ExceptionHandler(value = CommonException.class)
    public ResponseData handleCommonException(CommonException e, HttpServletRequest request) {
        log.error("自定义异常处理【url {}, msg {}】", request.getRequestURL(), e.getMessage());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("url", request.getRequestURL());
        if (e != null && e.getException() != null) {
            resultMap.put("errorMessage", e.getException().getMessage());
        }

        return ResponseData.error(e.getMsg(), resultMap);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseData handleCommonException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("自定义异常处理【url {}, msg {}】", request.getRequestURL(), e.getMessage());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("url", request.getRequestURL());
        ofNullable(e.getBindingResult().getFieldError())
                .ifPresent(fieldError -> resultMap.put("errorMessage", fieldError.getDefaultMessage()));

        return ResponseData.error(Constants.DATA_IS_ERROR, resultMap);
    }
}
