package com.fun.uncle.itoken.web.admin.service.fallback;

import com.fun.uncle.itoken.common.constants.HttpStatusConstants;
import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.dto.BaseResult;
import com.fun.uncle.itoken.common.hystrix.Fallback;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.fun.uncle.itoken.web.admin.service.AdminService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

/**
 * @Description: 熔断
 * @Author: Xian
 * @CreateDate: 2019/12/5  17:27
 * @Version: 0.0.1-SNAPSHOT
 */
@Component
public class AdminServiceFallback implements AdminService {


    @Override
    public String get(String userCode) {
        try {
            String json = MapperUtils.obj2json(new TbSysUser());
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String save(String tbSysUserJson, String optsBy) {
        return Fallback.badGateway();
    }

    @Override
    public String page(int pageNum, int pageSize, TbSysUser tbSysUser) {
        return Fallback.badGateway();
    }
}
