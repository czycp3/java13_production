package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public BaseResultVo<Product> selectAllProduct(int page, int rows) {
        BaseResultVo<Product> baseResultVo = new BaseResultVo<>();
        ProductExample productExample = new ProductExample();
        int total = (int) productMapper.countByExample(productExample);

        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;

        List<Product> products = productMapper.selectAllProduct(rows, offset);
        baseResultVo.setRows(products);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }
}
