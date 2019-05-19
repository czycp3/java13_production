package com.cskaoyan.service;


import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.ProductException;

import java.util.List;


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

    /**
     * 可选择字段更新产品信息
     * @param product
     * @return QueryStatus
     */
    QueryStatus updateByPrimaryKeySelective(Product product);

    /**
     * 批量删除产品
     * @param ids
     * @return QueryStatus
     */
    QueryStatus deleteBatch(String[] ids) throws ProductException;

    /**
     * 查询所有商品
     * @return List<Product>
     */
    List<Product> selectByExample();

    /**
     * 按照ID模糊搜索
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchProductById(String searchValue, int page, int rows);

    /**
     * 按照Name模糊搜索
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchProductByName(String searchValue, int page, int rows);

    /**
     * 按照Name模糊搜索
     * @param searchValue
     * @param page
     * @param rows
     * @return BaseResultVo
     */
    BaseResultVo searchProductByType(String searchValue, int page, int rows);

    /**
     * 查询产品的详情
     * @param productId
     * @return List<Product>
     */
    Product searchProductDetail(String productId);
}
