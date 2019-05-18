package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;

/**
 * @author CZY-Y7000P
 */
public interface OrderService {
    /**
     * 分页查询订单
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo selectAllOrder(int page, int rows);
}
