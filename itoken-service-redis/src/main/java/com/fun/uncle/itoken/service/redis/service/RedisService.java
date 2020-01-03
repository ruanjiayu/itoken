package com.fun.uncle.itoken.service.redis.service;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/6  16:12
 * @Version: 0.0.1-SNAPSHOT
 */
public interface RedisService {

    /**
     * 设置Redis内存储的内容
     * @param key key
     * @param value 值
     * @param seconds 存放时间的秒数
     */
    void set(String key, Object value, long seconds);

    /**
     * 取出Redis内存储的内容
     * @param key key
     * @return 内容
     */
    Object get(String key);
}
