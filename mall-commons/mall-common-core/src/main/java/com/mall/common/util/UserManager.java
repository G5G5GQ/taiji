package com.mall.common.util;

import com.mall.common.dto.UserContext;

import java.util.Objects;

public class UserManager {

    private static ThreadLocal<UserContext> CONTEXT = new ThreadLocal<>();


    /**
     * 用户上下文中放入信息
     *
     * @param userContext
     */
    public static void setContext(UserContext userContext) {
        CONTEXT.set(userContext);
    }

    /**
     * 获取上下文中的信息
     *
     * @return UserContext
     */
    public static UserContext getContext() {
        return CONTEXT.get();
    }

    /**
     * 清空上下文
     */
    public static void clear() {
        CONTEXT.remove();
    }

    /**
     * 获取用户ID
     * @return {@code Long}
     */
    public static Long getUserId() {
        UserContext userInfoContext = getContext();
        if (Objects.isNull(userInfoContext)) {
            return null;
        }
        return userInfoContext.getUserId();
    }


    /**
     * 获取用户账号
     * @return {@code String}
     */
    public static String getUserName() {
        UserContext userInfoContext = getContext();
        if (Objects.isNull(userInfoContext)) {
            return "errorUsername";
        }
        return userInfoContext.getUsername();
    }

    /**
     * 获取微信openId
     * @return {@code Long}
     */
    public static String getOpenId() {
        UserContext userInfoContext = getContext();
        if (Objects.isNull(userInfoContext)) {
            return "errorOpenId";
        }
        return userInfoContext.getOpenId();
    }


}
