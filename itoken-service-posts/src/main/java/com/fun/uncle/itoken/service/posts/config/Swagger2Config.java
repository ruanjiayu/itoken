package com.fun.uncle.itoken.service.posts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/12  13:37
 * @Version: 0.0.1-SNAPSHOT
 */

@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fun.uncle.itoken.service.posts.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("iToken API 文档")
                .description("服务名: itoken-service-ports\r\n" + "请求地址: ports.itoken.com")
                .termsOfServiceUrl("https://www.fununlce.top")
                .version("1.0.0")
                .build();
    }
}
