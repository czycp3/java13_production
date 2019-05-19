package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: zero
 * @Date: 2019/5/18 21:22
 * @Version 1.0
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public Employee[] getEmployees() {
        Employee[] employees = employeeMapper.getEmployees();
        return employees;
    }

    @Override
    public Employee selectEmployeeById(String deviceKeeperId) {
        Employee employee = employeeMapper.selectEmployeeById(deviceKeeperId);
        return employee;
    }

    @Override
    public QueryStatus updateEmployee(Employee employee) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            int i = employeeMapper.updateEmployee(employee);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("编辑失败，请重新尝试");
        }
        return queryStatus;

    }
}
