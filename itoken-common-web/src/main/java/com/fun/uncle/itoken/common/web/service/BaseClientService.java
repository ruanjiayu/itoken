package com.fun.uncle.itoken.common.web.service;

import com.fun.uncle.itoken.common.domain.BaseDomain;
import com.fun.uncle.itoken.common.hystrix.Fallback;

/**
 * @Description: 通用的消费者接口
 * @Author: Xian
 * @CreateDate: 2019/12/19  14:46
 * @Version: 0.0.1-SNAPSHOT
 */
public interface BaseClientService<T extends BaseDomain> {

    /**
     * 通用的消费者分页查询接口
     * @param pageNum 查询的个数
     * @param pageSize 查询的页数
     * @param domain 查询的json对象
     * @return
     */
    default String page(int pageNum, int pageSize, T domain) {
        return Fallback.badGateway();
    }
}
