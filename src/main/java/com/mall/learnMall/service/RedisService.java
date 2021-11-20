package com.mall.learnMall.service;

/**
 * @author ycd20
 * @date 2021/11/20
 * @time 9:12
 */
public interface RedisService {
    /**
     * save dates
     */
    void set(String key, String value);

    /**
     * get dates
     */
    String get(String key);

    /**
     * set overtime
     */
    boolean expire(String key, long expire);

    /**
     * delete dates
     */
    void remove(String key);

    /**
     * self add
     */
    Long increment(String key, long delta);
}
