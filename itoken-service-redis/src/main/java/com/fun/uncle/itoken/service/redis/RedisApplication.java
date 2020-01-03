package com.fun.uncle.itoken.service.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: Redis的相关服务
 * @Author: Xian
 * @CreateDate: 2019/12/6  15:41
 * @Version: 0.0.1-SNAPSHOT
 */
@SpringBootApplication
@EnableEurekaClient
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
