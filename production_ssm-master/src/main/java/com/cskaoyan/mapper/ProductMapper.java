package com.cskaoyan.mapper;

import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public interface ProductMapper {

    /**
     * 条件查询产品数量
     * @param example
     * @return 产品数量
     */
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    /**
     * 查询产品列表
     *  @param offset 偏移量
     *  @param rows 每页行数
     *  @return List<Product>
     */
    List<Product> selectAllProduct(@Param("rows") int rows,@Param("offset") int offset);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}