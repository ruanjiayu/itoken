package com.fun.uncle.itoken.service.posts.service.impl;

import com.fun.uncle.itoken.common.domain.TbPostsPost;
import com.fun.uncle.itoken.common.mapper.TbPostsPostMapper;
import com.fun.uncle.itoken.common.service.impl.BaseServiceImpl;
import com.fun.uncle.itoken.service.posts.service.PostsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/11  17:21
 * @Version: 0.0.1-SNAPSHOT
 */

@Service
@Transactional(readOnly = true)
public class PostServiceImpl extends BaseServiceImpl<TbPostsPost, TbPostsPostMapper> implements PostsService<TbPostsPost> {
}
