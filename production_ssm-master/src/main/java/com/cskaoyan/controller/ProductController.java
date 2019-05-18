package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.ProductException;
import com.cskaoyan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


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

    /*********产品展示************/
    @RequestMapping("/product/list")
    @ResponseBody
    public BaseResultVo product(int page, int rows){
        return productService.selectAllProduct(page, rows);
    }

    @RequestMapping("/product/find")
    public String productList(){
        return "product_list";
    }

    /*********添加产品************/

    @RequestMapping("/product/add_judge")
    public String customAddJudge(){
        return "product_add";
    }

    @RequestMapping("/product/add")
    public String customAdd(){

        return "product_add";
    }

    @RequestMapping("/product/insert")
    @ResponseBody
    public QueryStatus productInsert(Product product){
        return productService.insert(product);
    }

    @RequestMapping("/pic/upload")
    @ResponseBody
    public QueryStatus upload(MultipartFile uploadFile, HttpServletRequest req) throws IOException {
        String fileName = uploadFile.getOriginalFilename();
        fileName = UUID.randomUUID().toString().replace("-", "").toUpperCase() + "_" + fileName;
        String contextPath = req.getContextPath();
        String path = req.getServletContext().getRealPath("/WEB-INF/image/upload/");
        File file = new File(path + fileName);
        uploadFile.transferTo(file);
        QueryStatus queryStatus = new QueryStatus();
        queryStatus.setError(0);
        queryStatus.setUrl(contextPath + "/pic/" + fileName);
        return queryStatus;
    }

    /*********编辑产品************/

    @RequestMapping("/product/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/product/edit")
    public String edit(){
        return "product_edit";
    }

    @RequestMapping("/product/update_all")
    @ResponseBody
    public QueryStatus updateAll(Product product){
        return productService.updateByPrimaryKeySelective(product);
    }

    /**********删除客户*****************/

    @RequestMapping("/product/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return productService.deleteBatch(ids);
        } catch (ProductException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    @RequestMapping("/product/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }
}
