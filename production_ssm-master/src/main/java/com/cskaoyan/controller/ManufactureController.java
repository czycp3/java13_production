package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
