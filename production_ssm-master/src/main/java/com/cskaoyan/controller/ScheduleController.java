package com.cskaoyan.controller;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.CustomResultVo;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
