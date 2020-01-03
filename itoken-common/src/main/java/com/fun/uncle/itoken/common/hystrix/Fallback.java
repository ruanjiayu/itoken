package com.fun.uncle.itoken.common.hystrix;

import com.fun.uncle.itoken.common.constants.HttpStatusConstants;
import com.fun.uncle.itoken.common.dto.BaseResult;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.google.common.collect.Lists;

/**
 * @Description: 通用的熔断方法
 * @Author: Xian
 * @CreateDate: 2019/12/9  17:21
 * @Version: 0.0.1-SNAPSHOT
 */
public class Fallback {

    /**
     * 502错误
     *
     * @return
     */
    public static String badGateway() {
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error(
                        String.valueOf(HttpStatusConstants.BAD_GATEWAY.getCode()),
                        HttpStatusConstants.BAD_GATEWAY.getContents())));
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
