package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.exception.TechnologyException;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    //------查询列表--------
    @RequestMapping("/technology/list")
    @ResponseBody
    public BaseResultVo technology(int page, int rows){
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Technology> technologies = technologyService.selectAllTechnology(page,rows);
        int total = technologyService.selectCountTechnology();
        baseResultVo.setRows(technologies);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/technology/find")
    public String technologyList(){
        return "technology_list";
    }

    //------添加--------
    @RequestMapping("/technology/add_judge")
    public String technologyAddJudge(){
        return "technology_add";
    }

    @RequestMapping("/technology/add")
    public String technologyAdd(){

        return "technology_add";
    }

    @RequestMapping("/technology/insert")
    @ResponseBody
    public QueryStatus technologyInsert(Technology technology){
        return technologyService.insert(technology);
    }

    //------删除--------
    @RequestMapping("/technology/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/technology/delete_batch")
    @ResponseBody
    public QueryStatus technologyDelete(String[] ids){
        try {
            return technologyService.deleteBatch(ids);
        } catch (TechnologyException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    //------编辑--------
    @RequestMapping("/technology/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/technology/edit")
    public String edit(){
        return "technology_edit";
    }

    @RequestMapping("/technology/update_all")
    @ResponseBody
    public QueryStatus updateAll(Technology technology){
        return technologyService.updateAll(technology);
    }

    //------按条件查询--------
    @RequestMapping("/technology/search_technology_by_technologyId")
    @ResponseBody
    public BaseResultVo searchTechnologyById(String searchValue,int page, int rows){
        return technologyService.searchTechnologyById(searchValue,page,rows);
    }

    @RequestMapping("/technology/search_technology_by_technologyName")
    @ResponseBody
    public BaseResultVo searchTechnologybyName(String searchValue,int page, int rows){
        return technologyService.searchTechnologyByName(searchValue,page,rows);
    }
}
