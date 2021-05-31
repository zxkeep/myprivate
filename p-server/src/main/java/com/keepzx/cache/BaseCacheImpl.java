package com.keepzx.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class BaseCacheImpl<T> implements BaseCache<T> {

    private RedisTemplate<Serializable, T> redisTemplate;

    protected abstract String generateKey(String id);

    @Autowired
    protected void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    protected abstract void setRedisTemplate();



    /**
     * 写入缓存
     *
     * @param id
     * @param value
     * @param expireTime 单位为s
     * @return
     */
    public boolean set(final String id, T value, Long expireTime) {
        String key = generateKey(id);
        boolean result = false;
        try {
            ValueOperations<Serializable, T> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value, expireTime, TimeUnit.SECONDS);

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean set(final String id, T value) {
        String key = generateKey(id);
        boolean result = false;
        try {
            ValueOperations<Serializable, T> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public T get(final String id) {
        String key = generateKey(id);
        ValueOperations<Serializable, T> operations = redisTemplate
                .opsForValue();
        return operations.get(key);
    }


    /**
     * 刷新缓存失效时间
     * @param id
     * @param expireTime
     * @return
     */
    @Override
    public boolean updateOverTime(String id, long expireTime) {
        boolean result = false;
        String key = generateKey(id);
        try {
            result=redisTemplate.expire(key,expireTime,TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除对应的value
     *
     * @param id
     */
    public void remove(final String id) {
        String key = generateKey(id);
        if (exists(id)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param id
     * @return
     */
    public boolean exists(final String id) {
        String key = generateKey(id);
        return redisTemplate.hasKey(key);
    }



}
