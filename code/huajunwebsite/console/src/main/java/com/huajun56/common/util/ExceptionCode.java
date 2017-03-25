package com.huajun56.common.util;

/**
 * 错误code信息
 *
 * @author Bond(China)
 * @version 1.0.0
 */
public enum ExceptionCode {

    SYSTEM_ERROR("0000000", "系统错误，请联系系统管理员!"),
    ILLEGAL_PARAMETER("1000000", "非法参数错误!"),
    ILLEGAL_ACCESS("1000001", "非法访问/没有权限!"),
    FREQUENCY_ERROR("1000002", "频繁错误操作!"),
    UNKNOW_ERROR("1000003", "其它未知错误!"),

    WEBSERVICE_ERROR("1000004", "系统调用外部WEB服务调用错误!"),
    ILLEGAL_VALID_CODE("1000005", "验证码错误!"),
    PASSWORD_ERROR("1000006", "用户名或密码错误!"),
    UN_AUTHORIZED_ERROR("1000007", "请重新登入!"),
    ILLEGAL_CONTENT_TYPE("1000008", "不是可识别的请求参数类型，请仔细阅读接口文档或联系开发人员！"),

    REQUIRED_NOT_NULL("1000009", "必填参数不能空，请仔细核对接口要求！");

    private String code;

    private String message;

    private ExceptionCode(String value, String message) {
        this.code = value;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
