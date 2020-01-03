package com.fun.uncle.itoken.web.admin.config;

import com.fun.uncle.itoken.web.admin.interceptor.WebAdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 注册拦截器
 * @Author: Xian
 * @CreateDate: 2019/12/10  16:53
 * @Version: 0.0.1-SNAPSHOT
 */
@Configuration
public class WebAdminInterceptorConfig implements WebMvcConfigurer {



    @Bean
    public WebAdminInterceptor webAdminInterceptor(){
        return new WebAdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webAdminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static");
    }
}
