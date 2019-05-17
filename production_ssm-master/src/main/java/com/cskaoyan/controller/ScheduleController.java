package com.cskaoyan.controller;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.CustomResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.CustomException;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/custom/list")
    @ResponseBody
    public CustomResultVo custom(){
        CustomResultVo customResultVo = new CustomResultVo();
        List<Custom> customs = customService.selectAllCustom();
        int total = customs.size();
        customResultVo.setRows(customs);
        customResultVo.setTotal(total);
        return customResultVo;
    }

    @RequestMapping("/custom/find")
    public String customList(){
        return "custom_list";
    }

    @RequestMapping("/custom/add_judge")
    public String customAddJudge(){
        return "forward:/custom/list";
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
}
