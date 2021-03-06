package com.cskaoyan.mapper;

import com.cskaoyan.bean.BaseResultVo;
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

    /**
     * 按ID查询产品
     * @param productId
     * @return Product
     */
    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * 按选择字段
     * @param record
     * @return 更新成功行数
     */
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 查询所有产品
     * @return List<Product>
     */
    List<Product> selectTotalProduct();

    /**
     * 按条件查询product条目数
     * @param product
     * @return 数目
     */
    int selectCountProductByCondition(@Param("product") Product product);

    /**
     * 按条件查询product列表
     * @param product
     * @param rows
     * @param offset
     * @return product列表
     */
    List<Product> searchProductByCondition(@Param("product") Product product, @Param("rows") int rows, @Param("offset") int offset);
}