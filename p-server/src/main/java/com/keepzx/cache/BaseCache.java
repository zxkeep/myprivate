package com.keepzx.cache;

public interface BaseCache<T> {

    boolean set(final String id, T value);

    boolean set(final String id, T value, Long expireTime);

    /**
     * 刷新缓存失效时间
     * @param id
     * @param expireTime
     * @return
     */
    boolean updateOverTime(final String id,final long expireTime);

    T get(final String id);

    void remove(final String id);

    boolean exists(final String id);


}
