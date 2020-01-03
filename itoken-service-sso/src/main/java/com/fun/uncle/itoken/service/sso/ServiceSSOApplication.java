package com.fun.uncle.itoken.service.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/7  16:13
 * @Version: 0.0.1-SNAPSHOT
 */
@SpringBootApplication(scanBasePackages = "com.fun.uncle.itoken")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(value = "com.fun.uncle.itoken.service.sso.mapper")
public class ServiceSSOApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSSOApplication.class, args);
    }
}
