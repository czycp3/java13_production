package com.cskaoyan.bean;

/**
 * @Author: zero
 * @Date: 2019/5/18 21:24
 * @Version 1.0
 */

public class Employee {
    String birthday;
    String degree;
    Department department;
    String education;
    String educationForm;
    String empId;
    String empName;
    String graduateSchool;
    String idCode;
    String joinDate;
    String major;
    String sex;
    String status;

    @Override
    public String toString() {
        return "Employee{" +
                "birthday='" + birthday + '\'' +
                ", degree='" + degree + '\'' +
                ", department=" + department +
                ", education='" + education + '\'' +
                ", educationForm='" + educationForm + '\'' +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", idCode='" + idCode + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", major='" + major + '\'' +
                ", sex='" + sex + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

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

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getJionDate() {
        return joinDate;
    }

    public void setJionDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
