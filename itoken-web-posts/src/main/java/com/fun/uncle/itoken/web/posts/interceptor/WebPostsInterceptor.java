package com.fun.uncle.itoken.web.posts.interceptor;

import com.fun.uncle.itoken.common.utils.CookieUtils;
import com.fun.uncle.itoken.common.web.constants.WebConstants;
import com.fun.uncle.itoken.common.web.interceptor.BaseInterceptorMethods;
import com.fun.uncle.itoken.web.posts.service.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 配置拦截器
 * @Author: Xian
 * @CreateDate: 2019/12/10  16:50
 * @Version: 0.0.1-SNAPSHOT
 */
public class WebPostsInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return BaseInterceptorMethods.preHandleForLogin(request, response, handler, "http://localhost:8602/" + request.getServletPath());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(token)) {
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                BaseInterceptorMethods.postHandleForLogin(request, response, handler, modelAndView, redisService.get(loginCode), "http://localhost:8602/" + request.getServletPath());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
