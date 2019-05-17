package com.cskaoyan.bean;

import java.util.List;

/**
 * 封装客户list数据的bean
 * @author CZY-Y7000P
 */
public class CustomResultVo {
    private List<Custom> rows;
    private int total;

    public List<Custom> getRows() {
        return rows;
    }

    public void setRows(List<Custom> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
