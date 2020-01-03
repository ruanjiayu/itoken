package com.fun.uncle.itoken.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 返回的规范
 * @Author: Xian
 * @CreateDate: 2019/12/5  13:37
 * @Version: 0.0.1-SNAPSHOT
 */
@Data
public class BaseResult implements Serializable {
    private static final String RESULT_OK = "ok";
    private static final String RESULT_NOT_OK = "not_ok";
    private static final String SUCCESS = "成功操作";

    private String result;

    private Object data;

    private String success;

    private Cursor cursor;

    private List<Error> errors;


    public static BaseResult ok() {
        return createResult(RESULT_OK, null, SUCCESS, null, null);
    }

    public static BaseResult ok (String success) {
        return createResult(RESULT_OK, null, success, null, null);
    }

    public static BaseResult ok(Object data) {
        return createResult(RESULT_OK, data, SUCCESS, null, null);
    }

    public static BaseResult ok(Object data, Cursor cursor) {
        return createResult(RESULT_OK, data, SUCCESS, cursor, null);
    }

    public static BaseResult notOk(List<BaseResult.Error> errors) {
        return createResult(RESULT_NOT_OK, null, "", null, errors);
    }


    /**
     *
     * @param result
     * @param data
     * @param success
     * @param cursor
     * @param errors
     * @return
     */
    private static BaseResult createResult(String result, Object data, String success, Cursor cursor, List<Error> errors) {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setData(data);
        baseResult.setCursor(cursor);
        baseResult.setSuccess(success);
        baseResult.setErrors(errors);
        return baseResult;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Cursor {
        private int total;
        private int offset;
        private int limit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Error {
        private String field;
        private String message;
    }

}
