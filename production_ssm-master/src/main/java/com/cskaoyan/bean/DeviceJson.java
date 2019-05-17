package com.cskaoyan.bean;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/17 16:45
 * @Version 1.0
 */
@Component
public class DeviceJson {
    int total;
    List<Device> rows;

    public List<Device> getRows() {
        return rows;
    }

    public void setRows(List<Device> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
