package com.mall.redis.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description 统一redis key的命名
 * @date 2023/07/19 9:57
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedisKey {

    /**
     * Redis key 的前缀
     */
    private String prefix;

    /**
     * Redis key 的内容
     */
    private String key;

    public String of() {
        return String.format("%s:%s", prefix, key);
    }
}
