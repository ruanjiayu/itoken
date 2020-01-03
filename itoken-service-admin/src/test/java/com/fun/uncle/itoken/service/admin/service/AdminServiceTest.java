package com.fun.uncle.itoken.service.admin.service;

import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.service.admin.ServiceAdminApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/5  10:35
 * @Version: 0.0.1-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@ActiveProfiles(value = "prod")
@Transactional(readOnly = true)
@Rollback
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void register() {
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setLoginCode("1005572910@qq.com");
        tbSysUser.setUserName("xufan");
        tbSysUser.setPassword("123456");
        tbSysUser.setUserType("0");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setUpdateBy("ruanjiayu");
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setCorpCode("3306");
        tbSysUser.setCorpName("itoken");
        adminService.insert(tbSysUser, "xian");
    }


    @Test
    public void login() {
//        TbSysUser tbSysUser = adminService.login("ruanjiayu@qq.com", "123456");
//        Assert.assertNotNull(tbSysUser);
    }
}
