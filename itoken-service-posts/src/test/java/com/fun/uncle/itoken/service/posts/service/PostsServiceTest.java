package com.fun.uncle.itoken.service.posts.service;

import com.fun.uncle.itoken.common.domain.TbPostsPost;
import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.service.posts.ServicePostsApplication;
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

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/11  18:41
 * @Version: 0.0.1-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServicePostsApplication.class)
@ActiveProfiles(value = "prod")
public class PostsServiceTest {


    @Autowired
    private PostsService<TbPostsPost> postsService;

    @Test
    public void register() {
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(UUID.randomUUID().toString());
        tbPostsPost.setTitle("1005572910@qq.com");
        tbPostsPost.setTimePublished(new Date());
        tbPostsPost.setStatus("0");
        postsService.insert(tbPostsPost, "xian");
    }
}