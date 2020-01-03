package com.fun.uncle.itoken.service.posts.controller;

import com.fun.uncle.itoken.common.domain.TbPostsPost;
import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.dto.BaseResult;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.fun.uncle.itoken.service.posts.service.PostsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 文章管理服务
 * @Author: Xian
 * @CreateDate: 2019/12/11  17:27
 * @Version: 0.0.1-SNAPSHOT
 */

@RestController
@RequestMapping(value = "v1/posts")
public class PostsController {

    @Autowired
    private PostsService<TbPostsPost> postsService;


    /**
     * 查询对应的文章
     *
     * @param postGuid
     * @return
     */
    @GetMapping(value = "{postGuid}")
    public BaseResult get(@PathVariable(value = "postGuid") String postGuid) {
        TbPostsPost tbPostsPost = new TbPostsPost();
        tbPostsPost.setPostGuid(postGuid);
        TbPostsPost obj = postsService.selectOne(tbPostsPost);
        return BaseResult.ok(obj);
    }

    /**
     * 更新文章
     * @param tbPostsPostJson
     * @param optsBy
     * @return
     */
    @PostMapping
    public BaseResult save(@RequestParam String tbPostsPostJson, @RequestParam String optsBy) {

        int result = 0;
        TbPostsPost tbPostsPost = null;

        try {
            tbPostsPost = MapperUtils.json2pojo(tbPostsPostJson, TbPostsPost.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tbPostsPost != null) {
            // 主键为空表示新增
            if (StringUtils.isBlank(tbPostsPost.getPostGuid())) {
                result = postsService.insert(tbPostsPost, optsBy);
            }

            // 编辑
            else {
                result = postsService.update(tbPostsPost, optsBy);
            }
        }

        if (result > 0) {
            return BaseResult.ok("文章保存成功");
        }

        return BaseResult.ok("保存文章失败");

    }


    /**
     * 分页查询文章
     * @param pageNum
     * @param pageSize
     * @param tbPostsPost
     * @return
     */
    @ApiOperation(value = "分页查询文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "pageSize", value = "笔数", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "tbPostsPost", value = "文章类型", required = false, dataType = "TbPostsPost", paramType = "body")
    })
    @PostMapping(value = "page/{pageNum}/{pageSize}")
    public BaseResult page(
            @PathVariable(value = "pageNum") int pageNum,
            @PathVariable(value = "pageSize") int pageSize,
            @RequestBody(required = false) TbPostsPost tbPostsPost
    ) {
        PageInfo pageInfo = postsService.page(pageNum, pageSize, tbPostsPost);

        // 分页后的结果集
        List<TbPostsPost> tbPostsPostList = pageInfo.getList();

        //分装Cursor对象
        BaseResult.Cursor cursor = new BaseResult.Cursor();
        cursor.setTotal((int)pageInfo.getTotal());
        cursor.setOffset(pageInfo.getPageNum());
        cursor.setLimit(pageInfo.getPageSize());
        return BaseResult.ok(tbPostsPostList, cursor);
    }


}
