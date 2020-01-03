package com.fun.uncle.itoken.common.service;

import com.fun.uncle.itoken.common.domain.BaseDomain;
import com.github.pagehelper.PageInfo;

/**
 * @Description: 通用的service层
 * @Author: Xian
 * @CreateDate: 2019/12/11  11:08
 * @Version: 0.0.1-SNAPSHOT
 */
public interface BaseService<T extends BaseDomain> {

    /**
     * 插入数据
     *
     * @param t
     * @param createBy 创建者
     * @return
     */
    int insert(T t, String createBy);

    /**
     * 删除数据
     *
     * @param t
     * @return
     */
    int delete(T t);

    /**
     * 更新数据
     *
     * @param t
     * @param updateBy 更新人员
     * @return
     */
    int update(T t,String updateBy);

    /**
     * 查询单独的数据
     *
     * @param t
     * @return
     */
    T selectOne(T t);

    /**
     * 查询数量
     * @param t
     * @return
     */
    int count(T t);


    /**
     * 分页查询
     *
     * @param pageNum  几页
     * @param pageSize 显示几行
     * @param t        查询的条件
     * @return
     */
    PageInfo<T> page(int pageNum, int pageSize, T t);
}
