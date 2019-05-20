package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Task;
import com.cskaoyan.exception.TaskException;
import com.cskaoyan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CZY-Y7000P
 */
@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /*********派工展示************/
    @RequestMapping("/task/list")
    @ResponseBody
    public BaseResultVo task(int page, int rows){
        return taskService.selectAllTask(page, rows);
    }

    @RequestMapping("/task/find")
    public String taskList(){
        return "task_list";
    }

    /*********添加派工************/

    @RequestMapping("/task/add_judge")
    public String taskAddJudge(){
        return "task_add";
    }

    @RequestMapping("/task/add")
    public String taskAdd(){

        return "task_add";
    }

    @RequestMapping("/task/insert")
    @ResponseBody
    public QueryStatus taskInsert(Task task){
        return taskService.insert(task);
    }

    /********编辑派工*******************/

    @RequestMapping("/task/edit_judge")
    @ResponseBody
    public QueryStatus editJudge(){
        return new QueryStatus();
    }

    @RequestMapping("/task/edit")
    public String edit(){
        return "task_edit";
    }

    @RequestMapping("/task/update_all")
    @ResponseBody
    public QueryStatus updateAll(Task task){
        return taskService.updateByPrimaryKeySelective(task);
    }

    /**********删除订单*****************/

    @RequestMapping("/task/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids) throws TaskException {
        return taskService.deleteBatch(ids);
    }

    @RequestMapping("/task/delete_judge")
    @ResponseBody
    public QueryStatus deleteJudge(){
        return new QueryStatus();
    }

    /**********条件查询派工*****************/

    @RequestMapping("/task/search_task_by_taskId")
    @ResponseBody
    public BaseResultVo searchTaskByTaskId(String searchValue,int page, int rows){
        return taskService.searchTaskByTaskId(searchValue,page,rows);
    }

    @RequestMapping("/task/search_task_by_taskWorkId")
    @ResponseBody
    public BaseResultVo searchTaskByWorkId(String searchValue,int page, int rows){
        return taskService.searchTaskByWorkId(searchValue,page,rows);
    }

    @RequestMapping("/task/search_task_by_taskManufactureSn")
    @ResponseBody
    public BaseResultVo searchTaskByManufactureSn(String searchValue,int page, int rows){
        return taskService.searchTaskByManufactureSn(searchValue,page,rows);
    }
}
