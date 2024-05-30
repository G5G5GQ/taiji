package com.mall.common.enums;

import com.mall.common.base.IBaseEnum;
import lombok.Getter;

/**
 * @author
 * @description 性别枚举
 * @date 2023/09/02 11:54
 */
public enum SexEnum implements IBaseEnum<Integer> {


    MAN(1, "男"),

    WOMAN(2, "女");

    @Getter
    private Integer value;

    @Getter
    private String label;

    SexEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
