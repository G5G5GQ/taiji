package com.mall.redis.core;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @description redis公共服务
 * @date 2023/07/12 15:10
 */
public class RedisService {

    private RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T> T setValue(RedisKey key, T value) {
        redisTemplate.opsForValue().set(key.of(), value);
        return value;
    }

    public <T> T setValue(RedisKey key, T value, long seconds) {
        redisTemplate.opsForValue().set(key.of(), value, seconds, TimeUnit.SECONDS);
        return value;
    }

    public <T> T setValue(RedisKey key, T value, Long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key.of(), value, timeout, timeUnit);
        return value;
    }

    private Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Object getValue(RedisKey key) {
        return getValue(key.of());
    }

    public <T> T getValue(RedisKey key, Class<T> clazz) {
        return clazz.cast(getValue(key.of()));
    }

    public Hash hash() {
        return new Hash();
    }

    public class Hash {

        public void put(RedisKey key, String hashKey, String hashValue) {
            redisTemplate.opsForHash().put(key.of(), hashKey, hashValue);
        }

        public void putAll(RedisKey key, Map<String, Object> map) {
            redisTemplate.opsForHash().putAll(key.of(), map);
        }

        public <T> T get(RedisKey key, String hashKey, Class<T> clazz) {
            return clazz.cast(redisTemplate.opsForHash().get(key.of(), hashKey));
        }

        public Map<Object, Object> getAll(RedisKey key) {
            return redisTemplate.opsForHash().entries(key.of());
        }

    }

    public boolean delete(RedisKey key) {
        return Optional.ofNullable(redisTemplate.delete(key.of())).orElse(false);
    }


    public boolean expire(RedisKey key, long seconds) {
        return Optional.ofNullable(redisTemplate.expire(key.of(), seconds, TimeUnit.SECONDS)).orElse(false);
    }

    public boolean expire(RedisKey key, long timeout, TimeUnit timeUnit) {
        return Optional.ofNullable(redisTemplate.expire(key.of(), timeout, timeUnit)).orElse(false);
    }

    public long increment(RedisKey key) {
        return redisTemplate.opsForValue().increment(key.of(), 1);
    }

    /**
     * 如果该值没有设置过期时间,就返回-1,如果没有该值，就返回-2
     * @param key
     * @return long
     */
    public long expire(RedisKey key) {
        return redisTemplate.opsForValue().getOperations().getExpire(key.of());
    }

    public boolean isExpire(RedisKey key) {
        return expire(key) > 0 ? false : true;
    }

}
