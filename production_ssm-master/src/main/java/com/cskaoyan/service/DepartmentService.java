package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.exception.DepartmentException;

import java.util.List;

/**
 * @Author: 頽小废
 * @Date: 2019/5/18 00:02
 * @Compony: http://www.tuixiaofei.com
 */
public interface DepartmentService {

    /**
     * 查询所有的部门列表
     * @param page  当前页数
     * @param rows 每页行数
     * @return List<Department>
     */
    List<Department> findAllDepartment(int page,int rows);

    /**
     * 查询部门总数
     * @return
     */
    int findTotal();

    /**
     * 新增部门
     * @param department
     * @return
     */
    QueryStatus insertDepartment(Department department);

    /**
     * 获取部门data
     * @return
     */
    List<Department> getDepartmentData ();

    /**
     * 编辑部门
     * @param department
     * @return
     */
    QueryStatus departmentUpdateAll(Department department);

    /**
     * 删除部门
     * @param ids
     * @return
     * @throws DepartmentException
     */
    QueryStatus departmentDeleteBatch (String[] ids) throws DepartmentException;

    /**
     * 根据部门编号查询
     * @param id
     * @return
     */
    List<Department> searchDepartmentById(String id);
}
