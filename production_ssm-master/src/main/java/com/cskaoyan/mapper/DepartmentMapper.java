package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 頽小废
 * @Date: 2019/5/17 16:38
 * @Compony: http://www.tuixiaofei.com
 */
public interface DepartmentMapper {
    /**
     * 查询department列表
     * @param rows   每页行数
     * @param offset 偏移量
     * @return
     */

    List<Department> findAllDepartment(@Param("rows")int rows,@Param("offset")int offset);

    /**
     * 查询总记录数
     * @return
     */
    int findTotal();

    /**
     * 新增部门
     * @return
     * @param department
     */
    int insertDepartment(Department department);
    /**
     * 返回部门数据
     * @return
     */
    List<Department> getDepartmentData();

    /**
     * 编辑部门
     * @return
     * @param department
     */
    int departmentUpdateAll(Department department);

    /**
     * 删除部门
     * @param departmentId
     * @return
     */
    int departmentDeleteBatch(@Param("id") String departmentId);

    /**
     * 通过部门编号查询
     * @param departmentId
     * @return
     */
    List<Department> searchDepartmentById (@Param("id") String departmentId);
}
