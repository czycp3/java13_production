package com.cskaoyan.service.impl;

import com.cskaoyan.annotation.ProceedTime;
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
    @ProceedTime
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
    @ProceedTime
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
    @ProceedTime
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
    @ProceedTime
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
    @ProceedTime
    public List<Product> selectByExample() {
        return productMapper.selectTotalProduct();

    }

    @Override
    @ProceedTime
    public BaseResultVo searchProductById(String searchValue, int page, int rows) {
        Product product = new Product();
        product.setProductId("%" + searchValue +"%");
        return pageHandle(product,rows,page);
    }

    @Override
    @ProceedTime
    public BaseResultVo searchProductByName(String searchValue, int page, int rows) {
        Product product = new Product();
        product.setProductName("%" + searchValue +"%");
        return pageHandle(product,rows,page);
    }

    public BaseResultVo pageHandle(Product product,int rows,int page){
        BaseResultVo<Product> baseResultVo = new BaseResultVo<>();
        int total = productMapper.selectCountProductByCondition(product);
        //查询分页信息
        //如果总数小于单页条目数，则修改查询数目为total
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Product> products = productMapper.searchProductByCondition(product, rows, offset);
        //封装list和total
        baseResultVo.setRows(products);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @Override
    @ProceedTime
    public BaseResultVo searchProductByType(String searchValue, int page, int rows) {
        Product product = new Product();
        product.setProductType("%" + searchValue +"%");
        return pageHandle(product,rows,page);
    }

    @Override
    @ProceedTime
    public Product searchProductDetail(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }
}
