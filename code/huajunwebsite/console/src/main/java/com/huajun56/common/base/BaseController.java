/*
 * Copyright (c) 2016. Bond(China)
 */

package com.huajun56.common.base;

import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.util.ExceptionCode;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

public abstract class BaseController {

    @ExceptionHandler(Exception.class)
    protected Map<String, Object> handleException(Exception ex) {

        if (ex instanceof HttpMessageNotReadableException) {
            return failure(ExceptionCode.ILLEGAL_CONTENT_TYPE.getCode(), ExceptionCode.ILLEGAL_CONTENT_TYPE.getMessage(), ex);
        }
        if (ex instanceof UnauthenticatedException) {
            return failure(ExceptionCode.UN_AUTHORIZED_ERROR.getCode(), ExceptionCode.UN_AUTHORIZED_ERROR.getMessage(), ex);
        }
        if (ex instanceof ServiceException) {
            return failure(((ServiceException) ex).getCode(), ex.getMessage(), ex);
        }
        if (ex instanceof IncorrectCredentialsException) {
            return failure(ExceptionCode.ILLEGAL_PARAMETER.getCode(), "用户名或密码错误!", ex);
        }
        return failure(ExceptionCode.SYSTEM_ERROR.getCode(), ExceptionCode.SYSTEM_ERROR.getMessage(), ex);
    }

    /**
     * 加入结果
     *
     * @param key   KEY
     * @param value Value
     */
    protected void put(String key, Object value) {
        ResultMap.put(key, value);
    }

    /**
     * 加入结果
     *
     * @param key   KEY
     * @param value Value
     */
    protected void put(Integer key, Object value) {
        ResultMap.put(key.toString(), value);
    }

    /**
     * 加入结果，其KEY为result
     *
     * @param val Value
     */
    protected void put(Object val) {
        ResultMap.put(val);
    }

    /**
     * 设置成功的结果
     *
     * @return Map
     */
    protected Map<String, Object> success() {
        return ResultMap.success();
    }

    /**
     * 设置成功的结果
     *
     * @param value Value
     * @return Map
     */
    protected Map<String, Object> success(Object value) {
        put(value);
        return ResultMap.success();
    }

    /**
     * 设置成功的结果
     *
     * @param key   KEY
     * @param value Value
     * @return Map
     */
    protected Map<String, Object> success(String key, Object value) {
        put(key, value);
        return ResultMap.success();
    }

    /**
     * 设置失败的结果
     *
     * @param e An exception
     * @return Map
     */
    protected Map<String, Object> failure(Exception e) {
        return ResultMap.failure(e);
    }

    /**
     * 设置失败的结果
     *
     * @param message Message
     * @param e       An exception
     * @return Map
     */
    protected Map<String, Object> failure(String message, Exception e) {
        return ResultMap.failure(message, e);
    }

    /**
     * 设置失败的结果
     *
     * @param code
     * @param message
     * @return
     */
    protected Map<String, Object> failure(String code, String message) {
        return ResultMap.failure(code, message, new Exception());
    }

    /**
     * 设置失败的结果
     *
     * @param code
     * @param message
     * @return
     */
    protected Map<String, Object> failure(Integer code, String message) {
        return failure(code.toString(), message);
    }

    /**
     * 设置失败的结果
     *
     * @param code    Code
     * @param message Message
     * @param e       An exception
     * @return Map
     */
    protected Map<String, Object> failure(String code, String message, Exception e) {
        return ResultMap.failure(code, message, e);
    }

    /**
     * 设置失败的结果
     *
     * @param code    Code
     * @param message Message
     * @param e       An exception
     * @return Map
     */
    protected Map<String, Object> failure(Integer code, String message, Exception e) {
        return ResultMap.failure(code.toString(), message, e);
    }

}
