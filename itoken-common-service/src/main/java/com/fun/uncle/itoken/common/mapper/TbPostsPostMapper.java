package com.fun.uncle.itoken.common.mapper;

import com.fun.uncle.itoken.common.domain.TbPostsPost;
import com.fun.uncle.itoken.common.utils.RedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.MyMapper;

/**
* @Description:   
* @Author:         Xian
* @CreateDate:     2019/12/11  10:44
* @Version:        0.0.1-SNAPSHOT
*/
@CacheNamespace(implementation = RedisCache.class)
public interface TbPostsPostMapper extends MyMapper<TbPostsPost> {
}