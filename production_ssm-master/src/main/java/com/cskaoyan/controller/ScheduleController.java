package com.cskaoyan.controller;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.CustomException;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author CZY
 * 计划进度controller
 */
@Controller
public class ScheduleController {

    private CustomService customService;

    @Autowired
    public ScheduleController(CustomService customService) {
        this.customService = customService;
    }

    /**********添加客户*****************/

    @RequestMapping("/custom/list")
    @ResponseBody
    public BaseResultVo custom(int page, int rows){
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Custom> customs = customService.selectAllCustom(page,rows);
        int total = customService.selectCountCustom();
        baseResultVo.setRows(customs);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/custom/find")
    public String customList(){
        return "custom_list";
    }

    @RequestMapping("/custom/add_judge")
    public String customAddJudge(){
        return "custom_add";
    }

    @RequestMapping("/custom/add")
    public String customAdd(){

        return "custom_add";
    }

    @RequestMapping("/custom/insert")
    @ResponseBody
    public QueryStatus customInsert(Custom custom){
        return customService.insert(custom);
    }

    /**********删除客户*****************/

    @RequestMapping("/custom/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return customService.deleteBatch(ids);
        } catch (CustomException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    @RequestMapping("/custom/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    /**********编辑客户*****************/

    @RequestMapping("/custom/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/custom/edit")
    public String edit(){
        return "custom_edit";
    }

    @RequestMapping("/custom/update_all")
    @ResponseBody
    public QueryStatus updateAll(Custom custom){
        return customService.updateByPrimaryKeySelective(custom);
    }

    /**********查询客户*****************/

    @RequestMapping("/custom/search_custom_by_customId")
    @ResponseBody
    public BaseResultVo searchCustomById(String searchValue,int page, int rows){
        return customService.searchCustomById(searchValue,page,rows);
    }

    @RequestMapping("/custom/search_custom_by_customName")
    @ResponseBody
    public BaseResultVo searchCustom(String searchValue,int page, int rows){
        return customService.searchCustomByName(searchValue,page,rows);
    }

    /**********查询其它表的详情****************/

    @RequestMapping("/custom/get/{customId}")
    @ResponseBody
    public Custom searchCustomDetail(@PathVariable("customId") String customID){
        return customService.searchCustomDetail(customID);
    }


}
