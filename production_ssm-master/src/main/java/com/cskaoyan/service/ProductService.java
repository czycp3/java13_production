package com.cskaoyan.service;


import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.QueryStatus;


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

    /**
     * 插入一个产品
     * @param product
     * @return 成功行数
     */
    QueryStatus insert(Product product);
}
