package com.scxinglin.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/10.
 */
@Component
public class CaptchaImgCache extends BaseCacheImpl<String> {

//    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;
    @Override
    protected String generateKey(String id) {
        return "CaptchaImg"+id;
    }

    @Override
    @Autowired
    protected void setRedisTemplate() {
        super.setRedisTemplate(redisTemplate);
    }


}
