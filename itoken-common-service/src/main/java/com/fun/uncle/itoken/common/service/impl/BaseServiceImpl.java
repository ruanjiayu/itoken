package com.fun.uncle.itoken.common.service.impl;

import com.fun.uncle.itoken.common.domain.BaseDomain;
import com.fun.uncle.itoken.common.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.MyMapper;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/11  11:13
 * @Version: 0.0.1-SNAPSHOT
 */

@Service
@Transactional(readOnly = true)
public abstract class BaseServiceImpl<T extends BaseDomain, D extends MyMapper<T>> implements BaseService<T> {

    @Autowired
    private D dao;

    @Override
    @Transactional(readOnly = false)
    public int insert(T t, String createBy) {
        t.setCreateBy(createBy);
        t.setCreateDate(new Date());
        t.setUpdateBy(createBy);
        t.setUpdateDate(new Date());
        return dao.insert(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int delete(T t) {
        return dao.delete(t);
    }

    @Override
    @Transactional(readOnly = false)
    public int update(T t, String updateBy) {
        t.setUpdateBy(updateBy);
        t.setUpdateDate(new Date());
        return dao.updateByPrimaryKey(t);
    }

    @Override
    public T selectOne(T t) {
        return dao.selectOne(t);
    }

    @Override
    public int count(T t) {
        return dao.selectCount(t);
    }

    @Override
    public PageInfo<T> page(int pageNum, int pageSize, T t) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> tList= dao.select(t);
        PageInfo<T> pageInfo = new PageInfo<>(tList);
        return pageInfo;
    }
}
