package com.mall.common.result;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public enum BaseErrorCode implements IErrorCode, Serializable {

    SUCCESS("200", "请求成功"),

    /*内部接口异常码A0000*/
    SYSTEM_ERROR("A0001", "系统异常,请稍后再试"),
    PARAM_ERROR("A0002", "请求参数错误"),
    RESOURCE_NOT_FOUND("A0003", "请求资源不存在"),
    PARAM_IS_NULL("A0004", "请求必填参数为空"),
    ACCESS_UNAUTHORIZED("A0005", "访问未授权"),
    METHOD_NOT_ALLOWED("A0006", "不支持当前请求方法"),
    AUTHENTICATION_ERROR("A0007", "认证失败!"),
    SERVICE_NOT_FOUND("A0008", "Service Not Found"),
    ILLEGAL_ACCESS("A0009", "非法访问"),
    UNSUPPORTED_MEDIA_TYPE("A0010", "Unsupported Media Type"),
    SERVICE_CALL_ERROR("A0011", "服务调用异常"),

    USER_LOGIN_ERROR("A0200", "用户登录异常"),

    USER_NOT_EXIST("A0201", "用户不存在"),

    USER_ACCOUNT_LOCKED("A0202", "用户账户被冻结"),

    USER_ACCOUNT_INVALID("A0203", "用户账户已作废"),

    USER_PWD_BLANK("A0205", "用户或密码为空"),

    USER_SMS_CODE_EMPTY("A0206", "验证码不能为空"),

    USER_SMS_CODE_INVALID("A0207", "验证码有误,请重新输入"),

    WECAHT_CODE_EMPTY("A0208", "授权码不能为空"),

    WECAHT_ENCRYPTEDDATA_EMPTY("A0209", "小程序用户信息不能为空"),

    USERNAME_OR_PASSWORD_ERROR("A0210", "账号或密码有误,请重新输入"),

    PASSWORD_ENTER_EXCEED_LIMIT("A0211", "用户输入密码次数超限"),

    CLIENT_AUTHENTICATION_FAILED("A0212", "客户端认证失败"),

    INVALID_TOKEN("A0230", "认证信息无效或已过期"),

    AUTHENTICATION_INVALID("A0231", "用户认证信息无效"),

    VERIFY_CODE_ONE_DAY_LIMIT_NUM("A0232", "当天验证码发送次数超过上限"),

    REPEAT_DATA_ERROR("A0301", "请勿提交重复数据"),

    RECORD_NOT_FOUND("A0302", "记录未找到");

    private String code;

    private String message;

    @Override
    public String code() {
        return code;
    }

    @Override
    public String msg() {
        return message;
    }
}
