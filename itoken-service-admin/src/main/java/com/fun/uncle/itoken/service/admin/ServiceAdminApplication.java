package com.fun.uncle.itoken.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description: 服务生产者
 * @Author: Xian
 * @CreateDate: 2019/12/4  11:11
 * @Version: 0.0.1-SNAPSHOT
 */
@SpringBootApplication(scanBasePackages = "com.fun.uncle.itoken")
@EnableEurekaClient
@MapperScan(basePackages = {"com.fun.uncle.itoken.common.mapper", "com.fun.uncle.itoken.service.admin.mapper"})
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
    }
}
