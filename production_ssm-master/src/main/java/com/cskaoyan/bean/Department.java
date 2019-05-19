package com.cskaoyan.bean;

import java.io.Serializable;

/**
 * @Author: 頽小废
 * @Date: 2019/5/17 15:48
 * @Compony: http://www.tuixiaofei.com
 *
 * 部门管理
 */
public class Department implements Serializable {
    /**
     * 部门编号
     */
    private String departmentId;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 部门职责
     */
    private String note;

    public Department() {
    }

    public Department(String departmentId, String departmentName, String note) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.note = note;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
