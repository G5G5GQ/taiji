package com.mall.web.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangchao
 * @description web配置
 * @date 2023/09/07 9:00
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "mall.web")
@RefreshScope
public class CustomWebProperties {


    private WebMvcConfig webMvcConfig;

    @Getter
    @Setter
    public static class WebMvcConfig {
        /**
         * 是否开启默认webMvc配置
         */
        private boolean enableDefaultWebMvc = true;

        /**
         * 添加拦截器匹配路径
         */
        private List<String> addIcPathPatterns;

        /**
         * 排除拦截器匹配路径
         */
        private List<String> excludeIcPathPatterns;
    }
}
