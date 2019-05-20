package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 頽小废
 * @Date: 2019/5/18 21:23
 * @Version 1.0
 */
public interface EmployeeMapper {
    Employee[] getEmployees();

    /**
     * 通过用户id查询用户信息
     * @param deviceKeeperId
     * @return
     */
    Employee selectEmployeeById(@Param("deviceKeeperId") String deviceKeeperId);


    /**
     * 查询所有用户列表
     * @param rows
     * @param offset
     * @return
     */
    List<Employee> findAllEmployees(@Param("rows") int rows,@Param("offset") int offset);

    /**
     * 查询所有的用户的数量
     * @return
     */
    int findEmployeeTotal();

    /**
     * 获取departmentData
     * @param id
     * @return
     */
    Department getDepartmentData(@Param("id") String id);

    /**
     * update All employee
     * @param employee
     * @return
     */
    int employeeUpdateAll(Employee employee);


    /**
     * 新增员工
     * @param employee
     * @return
     */
    int insertEmployee(Employee employee);

    /**
     * 删除员工
     * @param id
     */
    void employeeDeleteBatch(String id);

}
