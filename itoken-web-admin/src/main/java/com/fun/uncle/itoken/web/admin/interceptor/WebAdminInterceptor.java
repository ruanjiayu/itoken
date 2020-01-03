package com.fun.uncle.itoken.web.admin.interceptor;

import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.utils.CookieUtils;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.fun.uncle.itoken.common.web.constants.WebConstants;
import com.fun.uncle.itoken.common.web.utils.HttpServletUtils;
import com.fun.uncle.itoken.web.admin.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 配置拦截器
 * @Author: Xian
 * @CreateDate: 2019/12/10  16:50
 * @Version: 0.0.1-SNAPSHOT
 */
public class WebAdminInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService redisService;

    @Value(value = "${hosts.sso}")
    private String hosts_sso;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);

        // token 为空表示一定没有登录
        if (StringUtils.isBlank(token)) {
            /*"http://localhost:8503/login?url=http://localhost:8601"*/
            response.sendRedirect(String.format("%s/login?url=", hosts_sso, HttpServletUtils.getFullPath(request)));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        TbSysUser tbSysUser = (TbSysUser) session.getAttribute(WebConstants.SESSION_USER);

        // 已经登录状态
        if (tbSysUser != null) {
            if (modelAndView != null) {
                modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
            }
        }

        // 未登录状态
        else {
            String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
            // 避免刚好到这一步出现token过期
            if (StringUtils.isNotBlank(token)) {
                // todo
                String loginCode = redisService.get(token);
                if (StringUtils.isNotBlank(loginCode)) {
                    String json = redisService.get(loginCode);
                    if (StringUtils.isNotBlank(json)) {
                        // 已登录状态，创建局部会话
                        tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                        if (modelAndView != null) {
                            modelAndView.addObject(WebConstants.SESSION_USER, tbSysUser);
                        }
                        request.getSession().setAttribute(WebConstants.SESSION_USER, tbSysUser);

                    }
                }
            }
        }

        // 二次确认是否有用户信息
        if (tbSysUser == null) {
            response.sendRedirect(String.format("%s/login?url=", hosts_sso, HttpServletUtils.getFullPath(request)));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
