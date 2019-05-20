package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.OrderException;

import java.util.List;

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

    /**
     * 按所选字段更新订单
     * @param order
     * @return QueryStatus
     */
    QueryStatus updateByPrimaryKeySelective(Order order);

    /**
     * 批量删除订单
     * @param ids 要删除的订单ID
     * @return QueryStatus
     */
    QueryStatus deleteBatch(String[] ids) throws OrderException;

    /**
     * 按ID分页查询订单
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchOrderById(String searchValue, int page, int rows);

    /**
     * 按客户名称分页查询订单
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchOrderByCustomName(String searchValue, int page, int rows);

    /**
     * 按产品名称分页查询订单
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchOrderByProductName(String searchValue, int page, int rows);

    /**
     * 按ID查询Order信息
     * @param orderId
     * @return Order
     */
    Order searchOrderDetail(String orderId);

    List<Order> searchOrderList();
}
