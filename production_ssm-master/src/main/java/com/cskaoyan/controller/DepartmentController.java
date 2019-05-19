package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.DepartmentException;
import com.cskaoyan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 頽小废
 * @Date: 2019/5/17 21:18
 * @Compony: http://www.tuixiaofei.com
 */

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    BaseResultVo resultVo = new BaseResultVo();

    /**********部门查询************/

    @RequestMapping("/department/find")
    public String findDepartment(){return "department_list"; }


    @RequestMapping("/department/list")
    @ResponseBody
    public BaseResultVo<Department> findAllDepartment(int page, int rows){


        List<Department> departmentList = departmentService.findAllDepartment(page,rows);
        int total = departmentService.findTotal();
        resultVo.setRows(departmentList);
        resultVo.setTotal(total);
        return resultVo;
    }

    /************部门新增*************/
    @RequestMapping("/department/add_judge")
    public String addDepartment(){

        return "department_add";
    }
    @RequestMapping("/department/add")
    public String departmentAdd(){

        return "department_add";
    }

    @RequestMapping("department/insert")
    @ResponseBody
    public QueryStatus departmentInsert(Department department){
        return departmentService.insertDepartment(department);
    }

    /*********部门编辑**********/
    @RequestMapping("/department/get_data")
    @ResponseBody
    public List<Department> getDepartmentData(){
        return departmentService.getDepartmentData();
    }

    @RequestMapping("/department/edit_judge")
    public String departmentEditJudge(){
        return "department_edit";
    }

    @RequestMapping("/department/edit")
    public String departmentEdit(){
        return "department_edit";
    }


    @RequestMapping("department/update_all")
    @ResponseBody
    public QueryStatus departmentUpdateAll(Department department){
        return departmentService.departmentUpdateAll(department);
    }

    /*********部门删除**********/
    @RequestMapping("department/delete_judge")
    @ResponseBody
    public QueryStatus departmentDeleteJudge(){
        return new QueryStatus();
    }

    @RequestMapping("department/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        try {
            return departmentService.departmentDeleteBatch(ids);
        } catch (DepartmentException e) {
            QueryStatus queryStatus = new QueryStatus();
            queryStatus.setStatus(0);
            queryStatus.setMsg(e.getMessage());
            return queryStatus;
        }
    }

    /**********条件查询************/
    @RequestMapping("department/search_department_by_departmentId")
    @ResponseBody
    public BaseResultVo<Department> searchDepartmentById(String id){
        BaseResultVo<Department> resultVo = new BaseResultVo<>();
        List<Department> departmentById = departmentService.searchDepartmentById(id);
        resultVo.setTotal(1);
        resultVo.setRows(departmentById);
        return resultVo;
    }
}
