package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.bean.Process;
import com.cskaoyan.exception.TechnologyException;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.service.TechnologyPlanService;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.service.impl.ProcessServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProcessController {
    @Autowired
    ProcessService processService;
    @Autowired
    TechnologyPlanService technologyPlanService;
    @Autowired
    TechnologyService technologyService;

    //--------接口--------
    @RequestMapping("/technologyPlan/get_data")
    @ResponseBody
    public List<TechnologyPlan> getTechnologyPlanData(){
        return technologyPlanService.selectByExample();
    }

    @RequestMapping("/process/get_data")
    @ResponseBody
    public List<Process> getData(){
        return processService.selectAll();
    }

    @RequestMapping("/process/get/{processId}")
    @ResponseBody
    public Process getData(@PathVariable("processId") String processId){
        return processService.selectByProcessId(processId);
    }

    @RequestMapping("/technology/get_data")
    @ResponseBody
    public List<Technology> getTechnologyData(){
        return technologyService.selectByExample();
    }

    @RequestMapping("/process/list")
    @ResponseBody
    public BaseResultVo process(int page, int rows){
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Process> processes = processService.selectAllProcess(page,rows);
        int total = processService.selectCountProcess();
        baseResultVo.setRows(processes);
        baseResultVo.setTotal(total);
        return baseResultVo;
    }

    @RequestMapping("/process/find")
    public String processList(){
        return "process_list";
    }

    //------添加--------
    @RequestMapping("/process/add_judge")
    public String processAddJudge(){
        return "process_add";
    }

    @RequestMapping("/process/add")
    public String processAdd(){

        return "process_add";
    }

    @RequestMapping("/process/insert")
    @ResponseBody
    public QueryStatus processInsert(Process process){
        return processService.insert(process);
    }

    //------删除--------
    @RequestMapping("/process/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/process/delete_batch")
    @ResponseBody
    public QueryStatus processDelete(String[] ids){
        try {
            return processService.deleteBatch(ids);
        } catch (TechnologyException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    //------编辑--------
    @RequestMapping("/process/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/process/edit")
    public String edit(){
        return "process_edit";
    }

    @RequestMapping("/process/update_all")
    @ResponseBody
    public QueryStatus updateAll(Process process){
        return processService.updateAll(process);
    }

    //------按条件查询--------
    //按工序编号查询
    @RequestMapping("/process/search_process_by_processId")
    @ResponseBody
    public BaseResultVo searchProcessById(String searchValue,int page, int rows){
        return processService.searchProcessByProcessId(searchValue,page,rows);
    }

    //按工序计划编号查询
    @RequestMapping("/process/search_process_by_technologyPlanId")
    @ResponseBody
    public BaseResultVo searchProcessByTechnologyPlanId(String searchValue,int page, int rows){
        return processService.searchProcessByTechnologyPlanId(searchValue,page,rows);
    }

}
