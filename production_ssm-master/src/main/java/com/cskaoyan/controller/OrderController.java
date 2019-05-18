package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CZY-Y7000P
 */
@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*********订单展示************/
    @RequestMapping("/order/list")
    @ResponseBody
    public BaseResultVo product(int page, int rows){
        return orderService.selectAllOrder(page, rows);
    }

    @RequestMapping("/order/find")
    public String productList(){
        return "order_list";
    }

    /*********添加订单************/

    @RequestMapping("/order/add_judge")
    public String customAddJudge(){
        return "order_add";
    }

    @RequestMapping("/order/add")
    public String customAdd(){

        return "order_add";
    }
}
