package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.OrderService;
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
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /*********订单展示************/
    @RequestMapping("/order/list")
    @ResponseBody
    public BaseResultVo product(int page, int rows){
        return orderService.selectAllOrder(page, rows);
    }

    @RequestMapping("/order/find")
    public String productList(){
        return "order_list";
    }

    /*********添加订单************/

    @RequestMapping("/order/add_judge")
    public String customAddJudge(){
        return "order_add";
    }

    @RequestMapping("/order/add")
    public String customAdd(){

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
}
