package com.fun.uncle.itoken.web.posts.config;


import com.fun.uncle.itoken.web.posts.interceptor.WebPostsInterceptor;
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
public class WebPostsInterceptorConfig implements WebMvcConfigurer {



    @Bean
    public WebPostsInterceptor webAdminInterceptor(){
        return new WebPostsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webAdminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static");
    }
}
