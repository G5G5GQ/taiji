package com.mall.common.enums;

import com.mall.common.base.IBaseEnum;
import lombok.Getter;

/**
 * 操作类型
 */
public enum OperationTypeEnum implements IBaseEnum<Integer> {

    SAVE(1, "保存"),

    UPDATE(2, "更新"),

    DELETE(3, "删除");

    @Getter
    private Integer value;

    @Getter
    private String label;

    OperationTypeEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

}
