package com.mall.web.http;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.mall.common.constant.SystemConstants.HttpHeader;
import com.mall.common.dto.UserContext;
import com.mall.common.util.UserManager;
import com.mall.web.autoconfigure.CustomWebProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 用户信息拦截器
 */
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private CustomWebProperties customWebProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        CustomWebProperties.WebMvcConfig webMvcConfig = customWebProperties.getWebMvcConfig();
        if (!webMvcConfig.isEnableDefaultWebMvc() || (CollectionUtil.isNotEmpty(webMvcConfig.getExcludeIcPathPatterns()) && PathMatchUtil.match(webMvcConfig.getExcludeIcPathPatterns(), request.getServletPath()))) {
            return true;
        }
        String userId = request.getHeader(HttpHeader.X_USER_ID);
        String username = request.getHeader(HttpHeader.X_USER_NAME);
        String openId = request.getHeader(HttpHeader.X_OPEN_ID);
        String communityId = request.getHeader(HttpHeader.X_C_COMMUNITY_ID);
        String houseId = request.getHeader(HttpHeader.X_C_HOUSE_ID);
        UserContext userContext = UserContext.builder().userId(Long.parseLong(Optional.ofNullable(userId).orElse("0")))
                                                        .username(username)
                                                        .openId(openId)
                                                        .build();
        if (log.isInfoEnabled()) {
            log.info("userContext值内容:{}", JSONUtil.toJsonStr(userContext));
        }
        UserManager.setContext(userContext);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserManager.clear();
    }
}
