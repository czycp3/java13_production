package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author: 頽小废
 * @Date: 2019/5/19 18:03
 * @Compony: http://www.tuixiaofei.com
 */

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("employee/get_data")
    @ResponseBody
    public Employee[] getEmployeeData(){
        return employeeService.getEmployees();
    }

    @RequestMapping("/employee/edit_judge")
    @ResponseBody
    public BaseResultVo employeeEditJudge(){
        return new BaseResultVo();
    }

    @RequestMapping("/employee/update_all")
    @ResponseBody
    public QueryStatus updateEmployee(Employee employee){
        return employeeService.updateEmployee(employee);
    }
}
