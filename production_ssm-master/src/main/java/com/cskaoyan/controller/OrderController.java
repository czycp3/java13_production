package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.OrderException;
import com.cskaoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


/**
 * @author CZY-Y7000P
 */
@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*********订单展示************/
    @RequestMapping("/order/list")
    @ResponseBody
    public BaseResultVo order(int page, int rows){
        return orderService.selectAllOrder(page, rows);
    }

    @RequestMapping("/order/find")
    public String orderList(){
        return "order_list";
    }

    /*********添加订单************/

    @RequestMapping("/order/add_judge")
    public String orderAddJudge(){
        return "order_add";
    }

    @RequestMapping("/order/add")
    public String orderAdd(){

        return "order_add";
    }

    @RequestMapping("/order/insert")
    @ResponseBody
    public QueryStatus orderInsert(Order order){
        return orderService.insert(order);
    }

    @RequestMapping("/file/upload")
    @ResponseBody
    public QueryStatus upload(MultipartFile file, HttpServletRequest req) throws IOException {
        String fileName = file.getOriginalFilename();
        String contextPath = req.getContextPath();

        // 将文件夹打散
        int i = fileName.hashCode();
        String hexString = Integer.toHexString(i);
        char[] chars = hexString.toCharArray();
        //取十六进制HashCode的前两位作为文件夹路径
        fileName = chars[0] + "/" + chars[1] + "/" + fileName;

        String path = req.getServletContext().getRealPath("/WEB-INF/file/");
        File uploadFile = new File(path + fileName);

        if (!uploadFile.getParentFile().exists()) {
            uploadFile.getParentFile().mkdirs();
        }

        file.transferTo(uploadFile);
        QueryStatus queryStatus = new QueryStatus();
        queryStatus.setError(0);
        queryStatus.setUrl(contextPath + "/file/" + fileName);
        return queryStatus;
    }

    @RequestMapping("/file/download")
    @ResponseBody
    public QueryStatus download(String fileName, HttpServletRequest req,HttpServletResponse resp){
        String path = req.getServletContext().getRealPath("/");
        String contextPath = req.getContextPath();
        String replace = fileName.replace(contextPath, "WEB-INF");

        int index = replace.lastIndexOf("/");
        String downloadFile = replace.substring(index + 1);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("multipart/form-data");
        resp.setHeader("Content-Disposition","attachment;fileName=" + downloadFile);

        try (InputStream inputStream = new FileInputStream(path + "/" + replace);
             ServletOutputStream outputStream = resp.getOutputStream()){

            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0){
                outputStream.write(b,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new QueryStatus();
    }

    /********编辑订单*******************/

    @RequestMapping("/order/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/order/edit")
    public String edit(){
        return "order_edit";
    }

    @RequestMapping("/order/update_all")
    @ResponseBody
    public QueryStatus updateAll(Order order){
        return orderService.updateByPrimaryKeySelective(order);
    }

    /**********删除订单*****************/

    @RequestMapping("/order/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return orderService.deleteBatch(ids);
        } catch (OrderException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    @RequestMapping("/order/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    /**********查询产品*****************/

    @RequestMapping("/order/search_order_by_orderId")
    @ResponseBody
    public BaseResultVo searchOrderById(String searchValue,int page, int rows){
        return orderService.searchOrderById(searchValue,page,rows);
    }

    @RequestMapping("/order/search_order_by_orderCustom")
    @ResponseBody
    public BaseResultVo searchOrderByCustomName(String searchValue,int page, int rows){
        return orderService.searchOrderByCustomName(searchValue,page,rows);
    }

    @RequestMapping("/order/search_order_by_orderProduct")
    @ResponseBody
    public BaseResultVo searchOrderByProductName(String searchValue,int page, int rows){
        return orderService.searchOrderByProductName(searchValue,page,rows);
    }

    /**********查询其它表的详情****************/

    @RequestMapping("/order/get/{orderId}")
    @ResponseBody
    public Order searchOrderDetail(@PathVariable("orderId") String orderId){
        return orderService.searchOrderDetail(orderId);
    }

    @RequestMapping("/order/get_data")
    @ResponseBody
    public List<Order> searchOrderData(){
        return orderService.searchOrderList();
    }
}
