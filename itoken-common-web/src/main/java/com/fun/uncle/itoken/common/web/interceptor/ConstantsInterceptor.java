package com.fun.uncle.itoken.common.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 配置拦截器,给前端页面赋予js,css的地址
 * @Author: Xian
 * @CreateDate: 2019/12/10  15:20
 * @Version: 0.0.1-SNAPSHOT
 */
public class ConstantsInterceptor implements HandlerInterceptor {

    private static final String HOST_CDN = "http://192.168.10.32";

    private static final String TEMPLATE_ADMIN_LTE = "adminlte/v2.4.3";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在使用@RestController调用的时候,modelAndView为null。而使用@Controller存在值
        if (modelAndView != null) {
            modelAndView.addObject("adminlte", HOST_CDN + "/" + TEMPLATE_ADMIN_LTE);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
