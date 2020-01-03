package com.fun.uncle.itoken.service.sso.service;

import com.fun.uncle.itoken.common.domain.TbSysUser;

/**
 * @Description: 服务提供者的服务
 * @Author: Xian
 * @CreateDate: 2019/12/9  16:56
 * @Version: 0.0.1-SNAPSHOT
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param loginCode     账户
     * @param plainPassword 明文密码
     * @return
     */
    TbSysUser login(String loginCode, String plainPassword);
}
