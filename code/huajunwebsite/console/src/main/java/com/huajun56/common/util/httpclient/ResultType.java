package com.huajun56.common.util.httpclient;

/**
 * Http Client 调用结果
 * Created by Bond(China) on 2016/11/25.
 */
public enum ResultType {

    FAILURE(500, "failure"), SUCCESS(200, "success");
    private int status;
    private String message;

    ResultType(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
