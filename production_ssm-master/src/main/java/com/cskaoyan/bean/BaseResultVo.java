package com.cskaoyan.bean;

import java.util.List;

/**
 * 封装list数据的bean
 * @author CZY-Y7000P
 */
public class BaseResultVo<T> {
    private List<T> rows;
    private int total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
