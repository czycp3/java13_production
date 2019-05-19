package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public BaseResultVo selectAllOrder(int page, int rows) {
        BaseResultVo<Order> baseResultVo = new BaseResultVo<>();
        OrderExample orderExample = new OrderExample();
        int total = (int) orderMapper.countByExample(orderExample);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Order> orders = orderMapper.selectAllOrder(rows, offset);
        baseResultVo.setRows(orders);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    public QueryStatus insert(Order order) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = orderMapper.insertSelective(order);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该订单编号已经存在，请更换客户编号！");
        }
        return queryStatus;
    }
}
