/*
 * Copyright (c) 2015. Bond(China)
 */

package com.huajun56.common.exception;

import com.huajun56.common.util.ExceptionCode;

public class ServiceException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 5509813495434079448L;

    private final String code;

    public ServiceException(String msg, Exception e) {
        super(msg, e);
        this.code = ExceptionCode.UNKNOW_ERROR.getCode();
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;

    }

    public ServiceException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.code = exceptionCode.getCode();
    }

    public ServiceException(ExceptionCode exceptionCode, Exception e) {
        super(exceptionCode.getMessage(), e);
        this.code = exceptionCode.getCode();
    }

    public String getCode() {
        return code;
    }
}
