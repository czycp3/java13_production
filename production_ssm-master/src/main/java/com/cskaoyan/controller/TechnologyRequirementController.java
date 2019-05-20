package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.exception.TechnologyException;
import com.cskaoyan.service.TechnologyRequirementService;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TechnologyRequirementController {

    @Autowired
    TechnologyRequirementService technologyRequirementService;
    @Autowired
    TechnologyService technologyService;

    //--------接口--------
    @RequestMapping("/technologyRequirement/get_data")
    @ResponseBody
    public List<Technology> getTechnologyData(){
        return technologyService.selectByExample();
    }

    //------查询列表--------
    @RequestMapping("/technologyRequirement/list")
    @ResponseBody
    public BaseResultVo process(int page, int rows){
        BaseResultVo baseResultVo = new BaseResultVo();
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.selectAllTechnologyRequirement(page,rows);
        int total = technologyRequirementService.selectCountTechnologyRequirement();
        baseResultVo.setRows(technologyRequirements);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/technologyRequirement/find")
    public String technologyRequirementList(){
        return "technologyRequirement_list";
    }

    //------添加--------
    @RequestMapping("/technologyRequirement/add_judge")
    public String technologyRequirementAddJudge(){
        return "technologyRequirement_add";
    }

    @RequestMapping("/technologyRequirement/add")
    public String technologyRequirementAdd(){
        return "technologyRequirement_add";
    }

    @RequestMapping("/technologyRequirement/insert")
    @ResponseBody
    public QueryStatus technologyRequirementInsert(TechnologyRequirement technologyRequirement){
        return technologyRequirementService.insert(technologyRequirement);
    }

    //------删除--------
    @RequestMapping("/technologyRequirement/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/technologyRequirement/delete_batch")
    @ResponseBody
    public QueryStatus technologyDelete(String[] ids){
        try {
            return technologyRequirementService.deleteBatch(ids);
        } catch (TechnologyException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    //------编辑--------
    @RequestMapping("/technologyRequirement/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/technologyRequirement/edit")
    public String edit(){
        return "technologyRequirement_edit";
    }

    @RequestMapping("/technologyRequirement/update_all")
    @ResponseBody
    public QueryStatus updateAll(TechnologyRequirement technologyRequirement){
        return technologyRequirementService.updateAll(technologyRequirement);
    }

    //------按条件查询--------
    //按工艺要求编号查询
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public BaseResultVo searchTechnologyPlanByTechnologyPlanId(String searchValue,int page, int rows){
        return technologyRequirementService.searchTechnologyRequirementById(searchValue,page,rows);
    }

    //按工艺名称查询
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public BaseResultVo searchTechnologyPlanbyTechnologyName(String searchValue,int page, int rows){
        return technologyRequirementService.searchTechnologyRequirementByName(searchValue,page,rows);
    }

    //更新工艺要求
    @RequestMapping("technologyRequirement/update_requirement")
    @ResponseBody
    public QueryStatus updateTechnologyRequirement(TechnologyRequirement technologyRequirement){
        return technologyRequirementService.updateRequirementById(technologyRequirement);
    }

}
