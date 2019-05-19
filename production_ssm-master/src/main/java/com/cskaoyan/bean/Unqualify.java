package com.cskaoyan.bean;

import java.util.Date;

/**
 * @auther 芮狼Dan
 * @date 2019-05-18 00:12
 * 不合格产品的bean
 */
public class Unqualify {

    private String unqualifyApplyId; //不合格申请编号
    private String productId; //不合格产品的ID，最终变为产品名称，超链接可以修改产品信息
    private String unqualifyItem; //不合格项目
    private Integer unqualifyCount; //不合格数量
    private String assemblyDate; //加工时间
    private String empId; //申请人ID，最终变为申请人姓名，超链接可以修改申请人信息
    private String applyDate; //申请时间
    private String note; //备注
    private String productName; //商品名
    private String empName; //雇员姓名

    public Unqualify() {
    }

    public Unqualify(String unqualifyApplyId, String productId, String unqualifyItem, Integer unqualifyCount, String assemblyDate, String empId, String applyDate, String note, String productName, String empName) {
        this.unqualifyApplyId = unqualifyApplyId;
        this.productId = productId;
        this.unqualifyItem = unqualifyItem;
        this.unqualifyCount = unqualifyCount;
        this.assemblyDate = assemblyDate;
        this.empId = empId;
        this.applyDate = applyDate;
        this.note = note;
        this.productName = productName;
        this.empName = empName;
    }

    public String getUnqualifyApplyId() {
        return unqualifyApplyId;
    }

    public void setUnqualifyApplyId(String unqualifyApplyId) {
        this.unqualifyApplyId = unqualifyApplyId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUnqualifyItem() {
        return unqualifyItem;
    }

    public void setUnqualifyItem(String unqualifyItem) {
        this.unqualifyItem = unqualifyItem;
    }

    public Integer getUnqualifyCount() {
        return unqualifyCount;
    }

    public void setUnqualifyCount(Integer unqualifyCount) {
        this.unqualifyCount = unqualifyCount;
    }

    public String getAssemblyDate() {
        return assemblyDate;
    }

    public void setAssemblyDate(String assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Unqualify{" +
                "unqualifyApplyId='" + unqualifyApplyId + '\'' +
                ", productId='" + productId + '\'' +
                ", unqualifyItem='" + unqualifyItem + '\'' +
                ", unqualifyCount=" + unqualifyCount +
                ", assemblyDate='" + assemblyDate + '\'' +
                ", empId='" + empId + '\'' +
                ", applyDate='" + applyDate + '\'' +
                ", note='" + note + '\'' +
                ", productName='" + productName + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
