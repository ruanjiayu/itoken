package com.fun.uncle.itoken.service.admin.mapper;

import com.fun.uncle.itoken.common.domain.TbSysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

/**
* @Description:    扩展的mapper文件，也就是填写一些自己想要SQL操作
* @Author:         Xian
* @CreateDate:     2019/12/11  10:41
* @Version:        0.0.1-SNAPSHOT
*/
@Repository
public interface TbSysUserExtendMapper extends MyMapper<TbSysUser> {
}