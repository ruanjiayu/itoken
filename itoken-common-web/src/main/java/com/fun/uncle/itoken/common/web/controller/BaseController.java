package com.fun.uncle.itoken.common.web.controller;

import com.fun.uncle.itoken.common.domain.BaseDomain;
import com.fun.uncle.itoken.common.utils.MapperUtils;
import com.fun.uncle.itoken.common.web.components.datatables.DataTablesResult;
import com.fun.uncle.itoken.common.web.service.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 通用的消费者controller
 * @Author: Xian
 * @CreateDate: 2019/12/19  11:10
 * @Version: 0.0.1-SNAPSHOT
 */
public abstract class BaseController<T extends BaseDomain, S extends BaseClientService<T>> {

    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;


    @ResponseBody
    @GetMapping(value = "page")
    public DataTablesResult page(HttpServletRequest request) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        // todo 存在问题，思路将page的参数值替换掉
        T obj = (T) new BaseDomain();

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        System.out.println("我进来了");
        String json = service.page(start, length, obj);
        DataTablesResult dataTablesResult = null;
        try {
            dataTablesResult = MapperUtils.json2pojo(json, DataTablesResult.class);
            dataTablesResult.setDraw(draw);
            dataTablesResult.setRecordsTotal(dataTablesResult.getCursor().getTotal());
            dataTablesResult.setRecordsFiltered(dataTablesResult.getCursor().getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesResult;
    }
}
