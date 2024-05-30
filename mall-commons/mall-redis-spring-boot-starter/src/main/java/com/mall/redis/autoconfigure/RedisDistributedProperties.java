package com.mall.redis.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author
 * @description redis缓存配置
 * @date 2023/07/07 16:40
 */
@Data
@ConfigurationProperties(prefix = RedisDistributedProperties.PREFIX)
public class RedisDistributedProperties {

    public static final String PREFIX = "mall.redis";

    /**
     * Key 前缀
     */
    private String prefix;

    /**
     * Key 前缀字符集
     */
    private String prefixCharset = "UTF-8";
}
