package com.cskaoyan.mapper;

import com.cskaoyan.bean.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zero
 * @Date: 2019/5/18 21:23
 * @Version 1.0
 */
public interface EmployeeMapper {
    Employee[] getEmployees();

    Employee selectEmployeeById(@Param("deviceKeeperId") String deviceKeeperId);

    int updateEmployee(@Param("updateEmployeeBean") Employee employee);
}
