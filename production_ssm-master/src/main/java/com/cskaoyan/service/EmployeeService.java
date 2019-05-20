package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.QueryStatus;

import com.cskaoyan.exception.EmployeeException;


/**
 * @Author: zero
 * @Date: 2019/5/18 21:21
 * @Version 1.0
 */
public interface EmployeeService {

    /**
     * 获得employee的信息
     * @return
     */
    Employee[] getEmployees();

    /**
     * 通过deviceKeeperId来查找员工
     * @param deviceKeeperId
     * @return
     */
    Employee selectEmployeeById(String deviceKeeperId);


    /**
     * 查询所有的employee
     * @param page
     * @param rows
     * @return
     */
    BaseResultVo findAllEmployees(int page,int rows);

    /**
     * 获取department的数据
     * @return
     * @param id
     */
    Department getDepartmentData(String id);

    /**
     * 编辑员工
     * @param employee
     * @return
     */
    QueryStatus employeeUpdateAll(Employee employee);

    /**
     * 新增员工
     * @param employee
     * @return
     */
    QueryStatus insertEmployee(Employee employee);


    /**
     * 删除员工
     * @param ids
     * @return
     * @throws EmployeeException
     */
    QueryStatus employeeDeleteBatch (String[] ids) throws EmployeeException;

}
