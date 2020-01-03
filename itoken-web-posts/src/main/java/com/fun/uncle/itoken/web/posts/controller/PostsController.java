package com.fun.uncle.itoken.web.posts.controller;

import com.fun.uncle.itoken.common.domain.TbPostsPost;
import com.fun.uncle.itoken.common.domain.TbSysUser;
import com.fun.uncle.itoken.common.dto.BaseResult;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.fun.uncle.itoken.common.web.constants.WebConstants;
import com.fun.uncle.itoken.common.web.controller.BaseController;
import com.fun.uncle.itoken.web.posts.service.PostsWebService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/16  14:07
 * @Version: 0.0.1-SNAPSHOT
 */

@Controller
public class PostsController extends BaseController<TbPostsPost, PostsWebService> {

    @Autowired
    private PostsWebService postsService;

    @ModelAttribute
    public TbPostsPost tbPostsPost(String postGuid) {
        TbPostsPost tbPostsPost = null;

        if (StringUtils.isBlank(postGuid)) {
            tbPostsPost = new TbPostsPost();
        } else {
            String json = postsService.get(postGuid);
            try {
                tbPostsPost = MapperUtils.json2pojo(json, TbPostsPost.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 二次确认是否为空
            if (tbPostsPost == null) {
                tbPostsPost = new TbPostsPost();
            }
        }

        return tbPostsPost;
    }

    /**
     * 跳转到首页
     *
     * @return
     */
    @GetMapping(value = {"", "main"})
    public String main() {
        return "main";
    }

    /**
     * 跳转列表页
     *
     * @return
     */
    @GetMapping(value = "index")
    public String index() {
        return "index";
    }

    /**
     * 跳转表单页面
     *
     * @return
     */
    @GetMapping(value = "form")
    public String form() {
        return "form";
    }

    /**
     * 保存文章
     *
     * @param tbPostsPost
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbPostsPost tbPostsPost, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        // 初始化
        tbPostsPost.setTimePublished(new Date());
        tbPostsPost.setStatus("0");

        TbSysUser admin = (TbSysUser) request.getSession().getAttribute(WebConstants.SESSION_USER);
        String tbPostsPostJson = MapperUtils.obj2json(tbPostsPost);
        String json = postsService.save(tbPostsPostJson, admin.getUserCode());
        BaseResult baseResult = MapperUtils.json2pojo(json, BaseResult.class);

        redirectAttributes.addFlashAttribute("baseResult", baseResult);
        if (baseResult.getSuccess().endsWith("成功")) {
            return "redirect:/index";
        }
        return "redirect:/form";
    }
}
