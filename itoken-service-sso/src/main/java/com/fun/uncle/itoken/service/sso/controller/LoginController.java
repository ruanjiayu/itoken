package com.fun.uncle.itoken.service.sso.controller;

import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.utils.CookieUtils;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.fun.uncle.itoken.common.web.constants.WebConstants;
import com.fun.uncle.itoken.service.sso.service.LoginService;
import com.fun.uncle.itoken.service.sso.service.consumer.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Description: 登录业务
 * @Author: Xian
 * @CreateDate: 2019/12/9  17:32
 * @Version: 0.0.1-SNAPSHOT
 */
@Controller
public class LoginController {
    private static final String OK = "ok";

    @Resource
    private LoginService loginService;

    @Resource
    private RedisService redisService;


    /**
     * 跳转到登录页面
     *
     * @return
     */
    @GetMapping(value = "login")
    public String login(@RequestParam(required = false) String url, HttpServletRequest request, Model model) {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
        // token 不为空可能已登录
        if (StringUtils.isNotBlank(token)) {
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                String json = redisService.get(loginCode);
                if (StringUtils.isNotBlank(json)) {
                    try {
                        TbSysUser tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                        // 已登录
                        if (tbSysUser != null) {
                            if (StringUtils.isNotBlank(url)) {
                                return "redirect:" + url;
                            }
                        }

                        // 将登录信息传到登录页
                        model.addAttribute(WebConstants.SESSION_USER, tbSysUser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("url", url);
        }

        return "login";
    }

    /**
     * 登录业务
     *
     * @param loginCode 账户名
     * @param password  明文密码
     * @param url       想要访问的页面
     * @return
     */
    @PostMapping(value = "login")
    public String login(
            @RequestParam String loginCode,
            @RequestParam String password,
            @RequestParam(required = false) String url,
            HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes, Model model) {
        TbSysUser tbSysUser = loginService.login(loginCode, password);

        // 登录失败
        if (tbSysUser == null) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误，请重新输入");
        }

        // 登录成功
        else {
            String token = UUID.randomUUID().toString();
            // 将token放入缓存中
            String result = redisService.set(token, loginCode, 24L * 60 * 60);
            // 不发生熔断等异常
            if (StringUtils.isNotBlank(result) && OK.equals(result)) {
                CookieUtils.setCookie(request, response, WebConstants.SESSION_TOKEN, token, 24 * 60 * 60);
                if (StringUtils.isNotBlank(url)) {
                    return "redirect:" + url;
                }
            }
            // 发生熔断或者其他情况
            else {
                redirectAttributes.addFlashAttribute("message", "服务器异常,请稍后再试");
            }
        }
        // 将原来的地址一直传递过去
        redirectAttributes.addFlashAttribute("url", url);

        return "redirect:/login";
    }


    /**
     * 注销
     * @param url
     * @param request
     * @param response
     * @param model
     * @return
     */
    @GetMapping(value = "logout")
    public String logout(@RequestParam(required = false) String url, HttpServletRequest request, HttpServletResponse response, Model model) {
        CookieUtils.deleteCookie(request, response, WebConstants.SESSION_TOKEN);

        return login(url, request, model);
    }
}
