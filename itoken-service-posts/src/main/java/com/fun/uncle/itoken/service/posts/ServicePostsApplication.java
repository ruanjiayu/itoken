package com.fun.uncle.itoken.service.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description: 文章服务提供者
 * @Author: Xian
 * @CreateDate: 2019/12/11  17:11
 * @Version: 0.0.1-SNAPSHOT
 */

@SpringBootApplication(scanBasePackages = "com.fun.uncle.itoken")
@EnableEurekaClient
@MapperScan(value = {"com.fun.uncle.itoken.common.mapper", "com.fun.uncle.itoken.service.posts.mapper"})
@EnableSwagger2
public class ServicePostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePostsApplication.class, args);
    }
}
