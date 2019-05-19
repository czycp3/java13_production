package com.cskaoyan.bean;

import java.util.Date;

/**
 * @Author: 頽小废
 * @Date: 2019/5/17 16:16
 * @Compony: http://www.tuixiaofei.com
 */
public class Employee {
    /**
     * 员工编号
     */
    private String empId;
    /**
     * 员工姓名
     */
    private String empName;
    /**
     * 员工性别
     */
    private char sex;
    /**
     * 身份证号
     */
    private String idCode;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 入职日期
     */
    private Date joinDate;
    /**
     * 员工状态
     */
    private String status;
    /**
     * 学历
     */
    private String education;
    /**
     * 学位
     */
    private String degree;
    /**
     * 专业
     */
    private String major;
    /**
     * 受教育形式
     */
    private String educationForm;
    /**
     * 所属部门
     */
    private String department;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
