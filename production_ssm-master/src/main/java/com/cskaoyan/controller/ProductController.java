package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author CZY-Y7000P
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/list")
    @ResponseBody
    public BaseResultVo product(int page, int rows){
        BaseResultVo baseResultVo = new BaseResultVo();
        return productService.selectAllProduct(page, rows);
    }

    @RequestMapping("/product/find")
    public String productList(){
        return "product_list";
    }
}
