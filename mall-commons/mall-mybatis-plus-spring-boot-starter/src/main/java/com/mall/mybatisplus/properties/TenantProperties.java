package com.mall.mybatisplus.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author
 * @description 多租户模式配置
 * @date 2024/01/25 0:06
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "mall.tenant")
public class TenantProperties {
    /**
     * 是否开启多租户
     */
    private Boolean enable = true;

    /**
     * 租户id字段名
     */
    private String column = "community_id";

    /**
     * 需要进行租户id过滤的表名集合
     */
    private List<String> filterTables;

    /**
     * 需要忽略的多租户的表，此配置优先filterTables，若此配置为空，则启用filterTables
     */
    private List<String> ignoreTables;

    /**
     * 需要排除租户过滤的登录用户名
     */
    private List<String> ignoreLoginNames;
}
