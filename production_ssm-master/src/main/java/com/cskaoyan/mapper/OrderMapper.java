package com.cskaoyan.mapper;

import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 分页查询订单
     * @param rows
     * @param offset
     * @return List<Order>
     */
    List<Order> selectAllOrder(@Param("rows") int rows, @Param("offset") int offset);

    /**
     * 按条件查询订单的总数
     * @param order
     * @return 总数
     */
    int selectCountOrderByCondition(@Param("order") Order order);

    /**
     * 按条件查询订单
     * @param order
     * @return List<Order>
     */
    List<Order> searchOrderByCondition(@Param("order") Order order, @Param("rows") int rows, @Param("offset") int offset);

    List<Order> selectOrderList();
}