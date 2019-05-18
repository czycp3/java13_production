package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.ProductExample;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.ProductException;
import com.cskaoyan.mapper.ProductMapper;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public QueryStatus insert(Product product) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = productMapper.insertSelective(product);
            if(ret == 1) {
                queryStatus.setStatus(200);
                queryStatus.setMsg("OK");
            }
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("该产品编号已经存在，请更换客户编号！");
        }
        return queryStatus;
    }

    @Override
    public QueryStatus updateByPrimaryKeySelective(Product product) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int ret = productMapper.updateByPrimaryKeySelective(product);
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
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteBatch(String[] ids) throws ProductException {
        QueryStatus queryStatus = new QueryStatus();
        try {
            for (String id : ids) {
                productMapper.deleteByPrimaryKey(id);
            }
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除出现故障，请重新尝试");
            throw new ProductException("删除出现故障，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public List<Product> selectByExample() {
        return productMapper.selectTotalProduct();

    }
}
