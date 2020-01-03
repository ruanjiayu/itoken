package com.fun.uncle.itoken.common.web.config;


import com.fun.uncle.itoken.common.web.interceptor.ConstantsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 注册拦截器
 * @Author: Xian
 * @CreateDate: 2019/12/10  15:18
 * @Version: 0.0.1-SNAPSHOT
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ConstantsInterceptor()).addPathPatterns("/**");
    }
}
