package com.cskaoyan.service;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.QueryStatus;

/**
 * @Author: zero
 * @Date: 2019/5/18 21:21
 * @Version 1.0
 */
public interface EmployeeService {

    Employee[] getEmployees();

    Employee selectEmployeeById(String deviceKeeperId);

    QueryStatus updateEmployee(Employee employee);
}
