package com.cskaoyan.service.impl;

import com.cskaoyan.annotation.ProceedTime;
import com.cskaoyan.bean.*;
import com.cskaoyan.exception.OrderException;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @ProceedTime
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
    @ProceedTime
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

    @Override
    @ProceedTime
    public QueryStatus updateByPrimaryKeySelective(Order order) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = orderMapper.updateByPrimaryKeySelective(order);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败！请重新尝试！");
        }
        return queryStatus;
    }

    @Override
    @ProceedTime
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteBatch(String[] ids) throws OrderException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                orderMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new OrderException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }


    public BaseResultVo pageHandle(Order order,int rows,int page){
        BaseResultVo<Order> baseResultVo = new BaseResultVo<>();
        int total = orderMapper.selectCountOrderByCondition(order);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Order> orders = orderMapper.searchOrderByCondition(order, rows, offset);
        //封装list和total
        baseResultVo.setRows(orders);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    @ProceedTime
    public BaseResultVo searchOrderById(String searchValue, int page, int rows) {
        Order order = new Order();
        Product product = new Product();
        Custom custom = new Custom();
        order.setOrderId("%" + searchValue +"%");
        order.setCustom(custom);
        order.setProduct(product);
        return pageHandle(order,rows,page);
    }

    @Override
    @ProceedTime
    public BaseResultVo searchOrderByCustomName(String searchValue, int page, int rows) {
        Custom custom = new Custom();
        custom.setCustomName("%" + searchValue +"%");
        Product product = new Product();
        Order order = new Order();
        order.setCustom(custom);
        order.setProduct(product);

        return pageHandle(order,rows,page);
    }

    @Override
    @ProceedTime
    public BaseResultVo searchOrderByProductName(String searchValue, int page, int rows) {
        Product product = new Product();
        product.setProductName("%" + searchValue +"%");
        Custom custom = new Custom();
        Order order = new Order();
        order.setProduct(product);
        order.setCustom(custom);

        return pageHandle(order,rows,page);
    }

    @Override
    @ProceedTime
    public Order searchOrderDetail(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    @ProceedTime
    public List<Order> searchOrderList() {
        return orderMapper.selectOrderList();
    }
}
