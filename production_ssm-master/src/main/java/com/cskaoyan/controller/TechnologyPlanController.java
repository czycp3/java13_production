package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;

//    //------查询列表--------
//    @RequestMapping("/technologyPlan/list")
//    @ResponseBody
//    public BaseResultVo technology(int page, int rows){
//        BaseResultVo baseResultVo = new BaseResultVo();
//        List<TechnologyPlan> technologyPlans = technologyPlanService.selectAllTechnologyPlan(page,rows);
//        int total = technologyPlanService.selectCountTechnologyPlan();
//        baseResultVo.setRows(technologyPlans);
//        baseResultVo.setTotal(total);
//        return baseResultVo;
//    }
//
//    @RequestMapping("/technologyPlan/find")
//    public String technologyList(){
//        return "technologyPlan_list";
//    }


}
