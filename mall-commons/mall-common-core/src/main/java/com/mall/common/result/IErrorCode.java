package com.mall.common.result;

/**
 * @author
 * @description 错误码接口
 * @date 2023/05/29 11:49
 */
public interface IErrorCode {

    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String msg();
}
