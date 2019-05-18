package com.cskaoyan.service;


import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Product;


/**
 * @author CZY-Y7000P
 */
public interface ProductService {
    /**
     * 查询所有产品
     * @param page
     * @param rows
     * @return  BaseResultVo<Product>
     */
    BaseResultVo<Product> selectAllProduct(int page, int rows);
}
