package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.QueryStatus;

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

    /**
     * 新增订单
     * @param order
     * @return QueryStatus
     */
    QueryStatus insert(Order order);
}
