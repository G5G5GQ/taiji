package com.mall.syslog.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author
 * @description 日志配置类
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "mall.syslog")
public class SysLogProperties {
    /**
     * 是否开启日志功能
     */
    private boolean enabled = true;
}
