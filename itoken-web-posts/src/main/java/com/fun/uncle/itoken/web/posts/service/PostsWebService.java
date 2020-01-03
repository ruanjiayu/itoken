package com.fun.uncle.itoken.web.posts.service;

import com.fun.uncle.itoken.common.domain.TbPostsPost;
import com.fun.uncle.itoken.common.web.service.BaseClientService;
import com.fun.uncle.itoken.web.posts.service.fallback.PostsWebServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/19  15:12
 * @Version: 0.0.1-SNAPSHOT
 */
@FeignClient(value = "itoken-service-posts", fallback = PostsWebServiceFallback.class)
public interface PostsWebService extends BaseClientService<TbPostsPost> {

    /**
     * 翻页查询
     * @param pageNum 查询的个数
     * @param pageSize 查询的页数
     * @param tbPostsPost
     * @return
     */
    @Override
    @RequestMapping(value = "v1/posts/page/{pageNum}/{pageSize}", method = RequestMethod.GET)
    String page(
            @PathVariable(value = "pageNum") int pageNum,
            @PathVariable(value = "pageSize") int pageSize,
            @RequestBody(required = false) TbPostsPost tbPostsPost
    );

    /**
     *
     * @param postGuid
     * @return
     */
    @RequestMapping(value = "v1/posts/{postGuid}", method = RequestMethod.GET)
    public String get(
            @PathVariable(required = true, value = "postGuid") String postGuid
    );

    @RequestMapping(value = "v1/posts", method = RequestMethod.POST)
    public String save(
            @RequestParam(required = true, value = "tbPostsPostJson") String tbPostsPostJson,
            @RequestParam(required = true, value = "optsBy") String optsBy
    );


}
