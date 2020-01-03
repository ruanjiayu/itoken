package com.fun.uncle.itoken.service.sso.service.impl;

import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.fun.uncle.itoken.service.sso.mapper.TbSysUserMapper;
import com.fun.uncle.itoken.service.sso.service.LoginService;
import com.fun.uncle.itoken.service.sso.service.consumer.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/9  16:59
 * @Version: 0.0.1-SNAPSHOT
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {


    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Resource
    private RedisService redisService;

    @Override
    public TbSysUser login(String loginCode, String plainPassword) {
        TbSysUser tbSysUser = null;
        String json = redisService.get(loginCode);

        // 缓存中没有数据，从数据库取数据
        if (json == null) {
            Example example = new Example(TbSysUser.class);
            example.createCriteria().andEqualTo("loginCode", loginCode);

            tbSysUser = tbSysUserMapper.selectOneByExample(example);
            String password = DigestUtils.md5DigestAsHex(plainPassword.getBytes());
            if (tbSysUser != null && password.equals(tbSysUser.getPassword())) {
                try {
                    redisService.set(loginCode, MapperUtils.obj2json(tbSysUser), 24L * 60 * 60);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return tbSysUser;
            } else {
                return null;
            }
        }

        // 缓存中存在数据
        else {
            try {
                tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                String password = DigestUtils.md5DigestAsHex(plainPassword.getBytes());
                // 如果密码不相等的话
                if (!password.equals(tbSysUser.getPassword())) {
                    return null;
                }
            } catch (Exception e) {
                log.warn("【服务熔断】:{}", e.getMessage());
            }
        }
        return tbSysUser;
    }


}
