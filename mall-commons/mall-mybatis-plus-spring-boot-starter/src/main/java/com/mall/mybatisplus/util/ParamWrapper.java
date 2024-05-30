package com.mall.mybatisplus.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.common.constant.DbConstants;

/**
 * @author
 * @description mybatis-plus参数构建构建类
 * @date 2023/10/24 13:51
 */
public class ParamWrapper {


    /**
     * 构建深度分页查询入参,默认ID倒序
     * @param cursor
     * @return {@code LambdaQueryWrapper<T>}
     */
    public static <T> LambdaQueryWrapper<T> queryWrapper(Long cursor) {
        if (cursor == null || cursor == 0 || cursor == 1) {
            return new QueryWrapper<T>().gt(DbConstants.ID_FIELD, 0).orderByDesc(DbConstants.ID_FIELD).lambda();
        }
        return new QueryWrapper<T>().lt(DbConstants.ID_FIELD, cursor).orderByDesc(DbConstants.ID_FIELD).lambda();
    }
}
