package com.fun.uncle.itoken.web.admin.service;

import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.web.service.BaseClientService;
import com.fun.uncle.itoken.web.admin.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/5  17:24
 * @Version: 0.0.1-SNAPSHOT
 */
@FeignClient(name = "itoken-service-admin", fallback = AdminServiceFallback.class)
@Component
public interface AdminService extends BaseClientService<TbSysUser> {
    /**
     * 根据 ID 获取管理员
     *
     * @return
     */
    @RequestMapping(value = "v1/admins", method = RequestMethod.GET)
    public String get(
            @RequestParam(required = true, value = "userCode") String userCode
    );

    /**
     * 保存管理员
     *
     * @return
     */
    @RequestMapping(value = "v1/admins", method = RequestMethod.POST)
    public String save(
            @RequestParam(required = true, value = "tbSysUserJson") String tbSysUserJson,
            @RequestParam(required = true, value = "optsBy") String optsBy
    );

    /**
     * 分页查询
     * @param pageNum 查询的个数
     * @param pageSize 查询的页数
     * @param tbSysUser
     * @return
     */
    @Override
    @RequestMapping(value = "v1/admins/page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public String page(
            @PathVariable(required = true, value = "pageNum") int pageNum,
            @PathVariable(required = true, value = "pageSize") int pageSize,
            @RequestBody(required = false) TbSysUser tbSysUser
    );
}
