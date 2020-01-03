package com.fun.uncle.itoken.service.redis.controller;

import com.fun.uncle.itoken.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/6  16:19
 * @Version: 0.0.1-SNAPSHOT
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping(value = "set")
    public String set(String key, String value, Long seconds) {
        redisService.set(key, value, seconds);
        return "ok";
    }

    @GetMapping(value = "get")
    public String get(String key) {
        Object o = redisService.get(key);
        if (o != null) {
            return String.valueOf(o);
        }
        return null;
    }
}
