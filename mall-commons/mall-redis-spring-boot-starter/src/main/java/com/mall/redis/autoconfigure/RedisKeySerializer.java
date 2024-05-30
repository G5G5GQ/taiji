package com.mall.redis.autoconfigure;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;

import java.nio.charset.Charset;

/**
 * @author
 * @description redis的key序列化
 * @date 2023/07/07 16:30
 */
public class RedisKeySerializer implements RedisSerializer<String> {

    private final String keyPrefix;

    private final Charset charset;

    public RedisKeySerializer(String keyPrefix, String charsetName) {
        this.keyPrefix = keyPrefix;
        this.charset = Charset.forName(charsetName);
    }

    public String deserialize(@Nullable byte[] bytes) {
        return bytes == null ? null : new String(bytes, this.charset);
    }

    public byte[] serialize(@Nullable String key) {
        return key == null ? null : (this.keyPrefix == null ? key.getBytes(this.charset) : (this.keyPrefix + ":" + key).getBytes(this.charset));
    }
}
