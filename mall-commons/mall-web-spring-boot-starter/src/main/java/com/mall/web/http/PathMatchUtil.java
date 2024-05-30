package com.mall.web.http;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import java.util.List;


/**
 * 路径匹配,匹配/**
 * @author
 * @date 2023/09/13 11:47
 */
public class PathMatchUtil {

    private static PathMatcher pathMatcher = new AntPathMatcher();

    public static boolean match(List<String> patterns, String path) {
        for (String pattern : patterns) {
            boolean match = pathMatcher.match(pattern, path);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
