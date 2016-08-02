package com.zyx.core.redis;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by MrDeng on 2016/7/28.
 */
public class RedisComponent implements IRedisComponent {
    private RedisTemplate<String, Long> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Long> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Boolean setIfAbsent(String key, Long timeMillisecond) {
        return this.redisTemplate.opsForValue().setIfAbsent(key, timeMillisecond);
    }

    @Override
    public Long get(String key) {
        return  this.redisTemplate.opsForValue().get(key);
    }

    @Override
    public Long getAndSet(String key, Long timeMillisecond) {
        return this.redisTemplate.opsForValue().getAndSet(key, timeMillisecond);
    }

    @Override
    public void delete(String key) {
        this.redisTemplate.delete(key);
    }
}
