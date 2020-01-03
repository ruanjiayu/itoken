package com.fun.uncle.itoken.web.posts.service.fallback;

import com.fun.uncle.itoken.common.domain.TbPostsPost;
import com.fun.uncle.itoken.common.hystrix.Fallback;
import com.fun.uncle.itoken.web.posts.service.PostsWebService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/19  15:14
 * @Version: 0.0.1-SNAPSHOT
 */
@Component
public class PostsWebServiceFallback implements PostsWebService {

    @Override
    public String page(int pageNum, int pageSize, TbPostsPost tbPostsPost) {
        return Fallback.badGateway();
    }


    @Override
    public String get(String postGuid) {
        return null;
    }

    @Override
    public String save(String tbPostsPostJson, String optsBy) {
        return Fallback.badGateway();
    }
}
