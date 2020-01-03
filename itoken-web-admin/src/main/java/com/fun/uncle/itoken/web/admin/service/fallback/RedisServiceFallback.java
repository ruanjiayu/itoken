package com.fun.uncle.itoken.web.admin.service.fallback;

import com.fun.uncle.itoken.web.admin.service.RedisService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/9  17:17
 * @Version: 0.0.1-SNAPSHOT
 */
@Component
public class RedisServiceFallback implements RedisService {

    @Override
    public String set(String key, String value, Long seconds) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

}
