package com.mall.mybatisplus.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.common.constant.DbConstants;
import com.mall.common.result.CursorPageResponse;
import com.mall.common.result.PageResponse;

import java.util.List;

/**
 * 分页工具类
 */
public class PageUtil {

    public static <T, O> PageResponse<T> convert(IPage<O> iPage, Class<T> targetClass) {
        iPage.convert(each -> BeanUtil.copyProperties(each, targetClass));
        return buildConventionPage(iPage);
    }

    private static PageResponse buildConventionPage(IPage iPage) {
        return PageResponse.builder().currentPage(iPage.getCurrent()).rows(iPage.getRecords()).total(iPage.getTotal()).totalPages(iPage.getPages()).build();
    }

    public static Page cursorPage(Integer pageSize) {
        return new Page<>(1, pageSize, false);
    }


    public static <T> CursorPageResponse cursorPageResp(List<T> list) {
        if (CollectionUtil.isEmpty(list)) {
            return CursorPageResponse.<T>builder().build();
        }
        return CursorPageResponse.<T>builder().rows(list).nextCursor((Long) ReflectUtil.getFieldValue(CollectionUtil.getLast(list), DbConstants.ID_FIELD)).build();
    }

    public static CursorPageResponse empty() {
        return CursorPageResponse.builder().build();
    }


}
