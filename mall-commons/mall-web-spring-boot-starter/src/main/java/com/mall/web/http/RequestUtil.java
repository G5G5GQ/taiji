package com.mall.web.http;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RequestUtil {


    /**
     * 获取请求认证信息
     * @return {@code String}
     */
    public static String getBearerAuth() {
        HttpServletRequest request = getRequest();
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StrUtil.isNotBlank(authorization) && StrUtil.startWithIgnoreCase(authorization, "Bearer ")) {
            return StrUtil.replaceIgnoreCase(authorization, "Bearer ", "");
        }
        return null;
    }

    /**
     * 获取当前请求的Request URL
     * @return {@code String}
     */
    public static String getRequestUrl() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return request.getRequestURL().toString();
        }
        return "";
    }

    /**
     * 获取请求IP
     * @return {@code String}
     */
    public static String getIp() {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return ServletUtil.getClientIP(request, null);
        }
        return "";
    }


    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getResponse();
    }

    public static void removeRequestAttributes() {
        RequestContextHolder.resetRequestAttributes();
    }

    public static void setRequestAttributes(RequestAttributes request) {
        RequestContextHolder.setRequestAttributes(request, true);
    }

    public static RequestAttributes getRequestAttributes() {
        return RequestContextHolder.getRequestAttributes();
    }

}
