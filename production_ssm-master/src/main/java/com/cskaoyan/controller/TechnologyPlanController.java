package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.exception.TechnologyException;
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

    //------查询列表--------
    @RequestMapping("/technologyPlan/list")
    @ResponseBody
    public BaseResultVo technology(int page, int rows){
        BaseResultVo baseResultVo = new BaseResultVo();
        List<TechnologyPlan> technologyPlans = technologyPlanService.selectAllTechnologyPlan(page,rows);
        int total = technologyPlanService.selectCountTechnologyPlan();
        baseResultVo.setRows(technologyPlans);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/technologyPlan/find")
    public String technologyList(){
        return "technologyPlan_list";
    }

    //------添加--------
    @RequestMapping("/technologyPlan/add_judge")
    public String technologyPlanAddJudge(){
        return "technologyPlan_add";
    }

    @RequestMapping("/technologyPlan/add")
    public String technologyPlanAdd(){
        return "technologyPlan_add";
    }

    @RequestMapping("/technologyPlan/insert")
    @ResponseBody
    public QueryStatus technologyPlanInsert(TechnologyPlan technologyPlan){
        return technologyPlanService.insert(technologyPlan);
    }

    //------删除--------
    @RequestMapping("/technologyPlan/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/technologyPlan/delete_batch")
    @ResponseBody
    public QueryStatus technologyDelete(String[] ids){
        try {
            return technologyPlanService.deleteBatch(ids);
        } catch (TechnologyException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    //------编辑--------
    @RequestMapping("/technologyPlan/edit")
    public String Edit(){
        return "technologyPlan_edit";
    }
    //------工艺计划编号列--------
    @RequestMapping("/technologyPlan/edit_judge")
    @ResponseBody
    public QueryStatus technologyPlanEditJudge(){
        return new QueryStatus();
    }

    //更新工艺计划信息
    @RequestMapping("technologyPlan/update_all")
    @ResponseBody
    public QueryStatus updateAll(TechnologyPlan technologyPlan){
        return technologyPlanService.updateAll(technologyPlan);
    }

    //------按条件查询--------
    //按工艺计划编号查询
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public BaseResultVo searchTechnologyPlanByTechnologyPlanId(String searchValue,int page, int rows){
        return technologyPlanService.searchTechnologyPlanByTechnologyPlanId(searchValue,page,rows);
    }

    //按工艺名称查询
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyName")
    @ResponseBody
    public BaseResultVo searchTechnologyPlanbyTechnologyName(String searchValue,int page, int rows){
        return technologyPlanService.searchTechnologyPlanbyTechnologyName(searchValue,page,rows);
    }


}
