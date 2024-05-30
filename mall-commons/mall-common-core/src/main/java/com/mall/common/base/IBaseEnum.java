package com.mall.common.base;

import cn.hutool.core.util.ObjectUtil;
import java.util.EnumSet;
import java.util.Objects;

/**
 * @author
 * @description 公共枚举接口
 * @date 2023/05/29 10:54
 */
public interface IBaseEnum<T> {

    T getValue();

    String getLabel();


    /**
     * 根据文本标签获取值
     *
     * @param label 标签
     * @param clazz clazz
     * @return {@code Object}
     */
    static <E extends Enum<E> & IBaseEnum> Object getValueByLabel(String label, Class<E> clazz) {
        Objects.requireNonNull(label);
        EnumSet<E> allEnums = EnumSet.allOf(clazz);
        String finalLabel = label;
        E matchEnum = allEnums.stream()
                .filter(e -> ObjectUtil.equal(e.getLabel(), finalLabel))
                .findFirst()
                .orElse(null);

        Object value = null;
        if (matchEnum != null) {
            value = matchEnum.getValue();
        }
        return value;
    }


    /**
     * 根据值获取枚举
     *
     * @param value 值
     * @param clazz clazz
     * @return {@code E}
     */
    static <E extends Enum<E> & IBaseEnum> E getEnumByValue(Object value, Class<E> clazz) {
        Objects.requireNonNull(value);
        EnumSet<E> allEnums = EnumSet.allOf(clazz);
        E matchEnum = allEnums.stream()
                .filter(e -> ObjectUtil.equal(e.getValue(), value))
                .findFirst()
                .orElse(null);
        return matchEnum;
    }


    /**
     * 根据值获取标签值
     *
     * @param value 值
     * @param clazz clazz
     * @return {@code String}
     */
    static <E extends Enum<E> & IBaseEnum> String getLabelByValue(Object value, Class<E> clazz) {
        Objects.requireNonNull(value);
        EnumSet<E> allEnums = EnumSet.allOf(clazz);
        return allEnums.stream()
                .filter(e -> ObjectUtil.equal(e.getValue(), value))
                .findFirst().map(IBaseEnum::getLabel).orElseGet(null);
    }

}
