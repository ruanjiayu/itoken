package com.fun.uncle.itoken.service.sso.service.consumer;

import com.fun.uncle.itoken.service.sso.service.consumer.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/9  17:02
 * @Version: 0.0.1-SNAPSHOT
 */
@FeignClient(value = "itoken-service-redis", fallback = RedisServiceFallback.class)
public interface RedisService {

    /**
     * 发送给redis的微服务端来进行对应的操作
     * @param key key
     * @param value 值
     * @param seconds 时间(秒)
     * @return
     */
    @PostMapping(value = "set")
     String set(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("seconds") Long seconds);

    /**
     * 向redis的微服务端发送请求来获取对应的值
     * @param key
     * @return
     */
    @GetMapping(value = "get")
    String get(@RequestParam("key") String key);
}
