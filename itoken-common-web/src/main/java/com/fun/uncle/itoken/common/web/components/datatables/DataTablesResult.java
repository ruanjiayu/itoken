package com.fun.uncle.itoken.common.web.components.datatables;

import com.fun.uncle.itoken.common.dto.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Description: Bootstrap Datatables 结果集
 * @Author: Xian
 * @CreateDate: 2019/12/19  14:50
 * @Version: 0.0.1-SNAPSHOT
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class DataTablesResult extends BaseResult implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private String error;
}
