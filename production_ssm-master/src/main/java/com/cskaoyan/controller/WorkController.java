package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Work;
import com.cskaoyan.exception.WorkException;
import com.cskaoyan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CZY-Y7000P
 */
@Controller
public class WorkController {

    private WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    /*********订单展示************/
    @RequestMapping("/work/list")
    @ResponseBody
    public BaseResultVo work(int page, int rows){
        return workService.selectAllWork(page, rows);
    }

    @RequestMapping("/work/find")
    public String workList(){
        return "work_list";
    }

    /*********添加订单************/

    @RequestMapping("/work/add_judge")
    public String workAddJudge(){
        return "work_add";
    }

    @RequestMapping("/work/add")
    public String workAdd(){

        return "work_add";
    }

    @RequestMapping("/work/insert")
    @ResponseBody
    public QueryStatus workInsert(Work work){
        return workService.insert(work);
    }

    /********编辑作业*******************/

    @RequestMapping("/work/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/work/edit")
    public String edit(){
        return "work_edit";
    }

    @RequestMapping("/work/update_all")
    @ResponseBody
    public QueryStatus updateAll(Work work){
        return workService.updateByPrimaryKeySelective(work);
    }


    /**********删除订单*****************/

    @RequestMapping("/work/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return workService.deleteBatch(ids);
        } catch (WorkException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    @RequestMapping("/work/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    /**********查询产品*****************/

    @RequestMapping("/work/search_work_by_workId")
    @ResponseBody
    public BaseResultVo searchWorkById(String searchValue,int page, int rows){
        return workService.searchWorkById(searchValue,page,rows);
    }

    @RequestMapping("/work/search_work_by_workProduct")
    @ResponseBody
    public BaseResultVo searchWorkByProduct(String searchValue,int page, int rows){
        return workService.searchWorkByProduct(searchValue,page,rows);
    }

    @RequestMapping("/work/search_work_by_workDevice")
    @ResponseBody
    public BaseResultVo searchWorkByDevice(String searchValue,int page, int rows){
        return workService.searchWorkByDevice(searchValue,page,rows);
    }

    @RequestMapping("/work/search_work_by_workProcess")
    @ResponseBody
    public BaseResultVo searchWorkByProcess(String searchValue,int page, int rows){
        return workService.searchWorkByProcess(searchValue,page,rows);
    }
}
