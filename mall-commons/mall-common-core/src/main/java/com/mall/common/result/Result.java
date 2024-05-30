package com.mall.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T data;
    private String code;
    private String msg;

    public static <T> Result<T> success() {
        return of(null, BaseErrorCode.SUCCESS.code(), null);
    }

    public static <T> Result<T> success(String msg) {
        return of(null, BaseErrorCode.SUCCESS.code(), msg);
    }

    public static <T> Result<T> success(T data, String msg) {
        return of(data, BaseErrorCode.SUCCESS.code(), msg);
    }

    public static <T> Result<T> success(T data) {
        return of(data, BaseErrorCode.SUCCESS.code(), null);
    }

    private static <T> Result<T> of(T data, String code, String msg) {
        return new Result<>(data, code, msg);
    }

    public static <T> Result<T> fail(String msg) {
        return of(null, BaseErrorCode.SYSTEM_ERROR.code(), msg);
    }

    public static <T> Result<T> fail(T data, String msg) {
        return of(data, BaseErrorCode.SYSTEM_ERROR.code(), msg);
    }

    public static <T> Result<T> fail(IErrorCode errorCode) {
        return of(null, errorCode.code(), errorCode.msg());
    }

    public static <T> Result<T> fail(IErrorCode errorCode, String msg) {
        return of(null, errorCode.code(), msg);
    }
}
