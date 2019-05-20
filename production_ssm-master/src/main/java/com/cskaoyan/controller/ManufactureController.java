package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.ManufactureException;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Controller
public class ManufactureController {

    private ManufactureService manufactureService;

    @Autowired
    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    /*********生产计划展示************/
    @RequestMapping("/manufacture/list")
    @ResponseBody
    public BaseResultVo manufacture(int page, int rows){
        return manufactureService.selectAllManufacture(page, rows);
    }

    @RequestMapping("/manufacture/find")
    public String manufactureList(){
        return "manufacture_list";
    }

    /*********添加生产计划************/

    @RequestMapping("/manufacture/add_judge")
    public String manufactureAddJudge(){
        return "manufacture_add";
    }

    @RequestMapping("/manufacture/add")
    public String manufactureAdd(){
        return "manufacture_add";
    }

    @RequestMapping("/manufacture/insert")
    @ResponseBody
    public QueryStatus manufactureInsert(Manufacture manufacture){
        return manufactureService.insert(manufacture);
    }

    /********编辑生产计划*******************/

    @RequestMapping("/manufacture/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/manufacture/edit")
    public String edit(){
        return "manufacture_edit";
    }

    @RequestMapping("/manufacture/update_all")
    @ResponseBody
    public QueryStatus updateAll(Manufacture manufacture){
        return manufactureService.updateByPrimaryKeySelective(manufacture);
    }

    /**********删除生产计划*****************/

    @RequestMapping("/manufacture/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return manufactureService.deleteBatch(ids);
        } catch (ManufactureException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    @RequestMapping("/manufacture/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    /**********查询生产计划*****************/

    @RequestMapping("/manufacture/search_manufacture_by_manufactureSn")
    @ResponseBody
    public BaseResultVo searchManufactureByManufactureSn(String searchValue,int page, int rows){
        return manufactureService.searchManufactureByManufactureSn(searchValue,page,rows);
    }

    @RequestMapping("/manufacture/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public BaseResultVo searchManufactureByManufactureOrderId(String searchValue,int page, int rows){
        return manufactureService.searchManufactureByManufactureOrderId(searchValue,page,rows);
    }

    @RequestMapping("/manufacture/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public BaseResultVo searchManufactureByManufactureTechnologyName(String searchValue,int page, int rows){
        return manufactureService.searchManufactureByManufactureTechnologyName(searchValue,page,rows);
    }

    /**********查询其它表的详情****************/

    @RequestMapping("/manufacture/get/{manufactureId}")
    @ResponseBody
    public Manufacture searchManufactureDetail(@PathVariable("manufactureId") String manufactureId){
        return manufactureService.searchManufactureDetail(manufactureId);
    }

    @RequestMapping("/manufacture/get_data")
    @ResponseBody
    public List<Manufacture> searchOrderData() {
        return manufactureService.searchManufactureList();
    }
}
