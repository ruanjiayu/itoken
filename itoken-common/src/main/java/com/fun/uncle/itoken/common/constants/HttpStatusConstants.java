package com.fun.uncle.itoken.common.constants;

/**
 * @Description: HTTP 状态码
 * @Author: Xian
 * @CreateDate: 2019/12/6  10:30
 * @Version: 0.0.1-SNAPSHOT
 */
public enum HttpStatusConstants {
    BAD_GATEWAY(502, "从上游服务器接收到无效的响应"),
    GATEWAY_TIMEOUT(504, "未能及时从上游服务器收到相应");

    private int code;

    private String contents;

    HttpStatusConstants(int code, String contents) {
        this.code = code;
        this.contents = contents;
    }

    public int getCode() {
        return code;
    }

    public String getContents() {
        return contents;
    }
}
