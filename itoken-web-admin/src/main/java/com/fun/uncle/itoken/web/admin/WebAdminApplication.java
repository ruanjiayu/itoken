package com.fun.uncle.itoken.web.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: 服务消费者
 * @Author: Xian
 * @CreateDate: 2019/12/5  16:59
 * @Version: 0.0.1-SNAPSHOT
 */

@SpringBootApplication(scanBasePackages = "com.fun.uncle.itoken")
@EnableDiscoveryClient
@EnableFeignClients
public class WebAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminApplication.class, args);
    }
}
