package com.fun.uncle.itoken.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Description:   
* @Author:         Xian
* @CreateDate:     2019/12/11  10:44
* @Version:        0.0.1-SNAPSHOT
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_posts_post")
@ApiModel
public class TbPostsPost extends BaseDomain implements Serializable {
    /**
     * 文章编码
     */
    @Id
    @Column(name = "post_guid")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(name = "postGuid", value = "文章编号")
    private String postGuid;

    /**
     * 文章标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 文章发布时间
     */
    @Column(name = "time_published")
    private Date timePublished;

    /**
     * 文章状态（0草稿 1已发布的文章 2待审核的文章 3被拒绝文章 4定时发布的文章）
     */
    @Column(name = "`status`")
    private String status;

    /**
     * 文章别名
     */
    @Column(name = "`alias`")
    private String alias;

    /**
     * 文章得分
     */
    @Column(name = "score")
    private Short score;

    /**
     * 文章摘要
     */
    @Column(name = "summary")
    private String summary;

    /**
     * 文章正文
     */
    @Column(name = "main")
    private String main;

    /**
     * 文章作者对象
     */
    @Column(name = "authors")
    private String authors;

    /**
     * 封面缩略图片
     */
    @Column(name = "thumb_image")
    private String thumbImage;

    /**
     * 裁剪后不带尺寸的正文图片数组
     */
    @Column(name = "original_images")
    private String originalImages;

    /**
     * 裁剪后带尺寸的正文图片数组
     */
    @Column(name = "images")
    private String images;

    /**
     * 裁剪前的正文图片数组
     */
    @Column(name = "full_size_images")
    private String fullSizeImages;

    /**
     * 文章标签
     */
    @Column(name = "tags")
    private String tags;

    /**
     * 文章特色标签
     */
    @Column(name = "v_tags")
    private String vTags;

    /**
     * 被赞数
     */
    @Column(name = "number_of_upvotes")
    private Integer numberOfUpvotes;

    /**
     * 被踩数
     */
    @Column(name = "number_of_downvotes")
    private Integer numberOfDownvotes;

    /**
     * 被阅读数
     */
    @Column(name = "number_of_reads")
    private Integer numberOfReads;

    /**
     * 被分享数
     */
    @Column(name = "number_of_shares")
    private Integer numberOfShares;

    /**
     * 被收藏数
     */
    @Column(name = "number_of_bookmarks")
    private Integer numberOfBookmarks;

    /**
     * 被评论数
     */
    @Column(name = "number_of_comments")
    private Integer numberOfComments;

    /**
     * 文章审核被拒理由
     */
    @Column(name = "reject_msg")
    private String rejectMsg;

    /**
     * 一篇文章的系列集合
     */
    @Column(name = "series")
    private String series;

    /**
     * 文章的阅读权限（0无限制 1会员）
     */
    @Column(name = "`access`")
    private String access;



    private static final long serialVersionUID = 1L;
}