package com.mall.common.constant;

/**
 * 系统常量
 */
public interface SystemConstants {

    /**
     * 滚动分页参数
     */
    interface CursorPage {
        /**
         * 游标位置
         */
        String CURSOR = "cursor";
        /**
         * 页面大小
         */
        String PAGE_SIZE = "pageSize";
    }
    
    /**
     * http请求相关
     */
    interface HttpHeader {
        String X_USER_ID = "x-user-id";
        String X_USER_NAME = "x-user-name";
        String X_USER_IP = "x-user-ip";
        String X_OPEN_ID = "x-open-id";
        //当前小区ID
        String X_C_COMMUNITY_ID = "x-c-community-id";
        //当前房号ID
        String X_C_HOUSE_ID = "x-c-house-id";
    }

}
