package com.fun.uncle.itoken.service.admin.service.impl;


import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.mapper.TbSysUserMapper;
import com.fun.uncle.itoken.common.service.impl.BaseServiceImpl;
import com.fun.uncle.itoken.service.admin.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/5  10:53
 * @Version: 0.0.1-SNAPSHOT
 */
@Transactional(readOnly = true)
@Service
public class AdminServiceImpl extends BaseServiceImpl<TbSysUser, TbSysUserMapper> implements AdminService<TbSysUser> {


}
