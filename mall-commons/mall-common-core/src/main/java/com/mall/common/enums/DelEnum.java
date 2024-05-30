package com.mall.common.enums;

import com.mall.common.base.IBaseEnum;
import lombok.Getter;

/**
 * 删除标记枚举
 */
public enum DelEnum implements IBaseEnum<Integer> {

    NORMAL(0, "正常"),
    DELETE(1, "删除");

    @Getter
    private Integer value;

    @Getter
    private String label;

    DelEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }


}
