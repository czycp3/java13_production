package com.cskaoyan.bean;

import java.math.BigDecimal;

/**
 * @Author: zero
 * @Date: 2019/5/20 20:11
 * @Version 1.0
 */
public class DeviceMaintain {
    String deviceFaultId;
    BigDecimal deviceMaintainCost;
    String deviceMaintainDate;
    String deviceMaintainEmp;
    String deviceMaintainEmpId;
    String deviceMaintainId;
    String deviceMaintainResult;
    String note;
    Object deviceMaintainParams;

    @Override
    public String toString() {
        return "DeviceMaintain{" +
                "deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceMaintainCost=" + deviceMaintainCost +
                ", deviceMaintainDate='" + deviceMaintainDate + '\'' +
                ", deviceMaintainEmp='" + deviceMaintainEmp + '\'' +
                ", deviceMaintainEmpId='" + deviceMaintainEmpId + '\'' +
                ", deviceMaintainId='" + deviceMaintainId + '\'' +
                ", deviceMaintainResult='" + deviceMaintainResult + '\'' +
                ", note='" + note + '\'' +
                ", deviceMaintainParams=" + deviceMaintainParams +
                '}';
    }

    public Object getDeviceMaintainParams() {
        return deviceMaintainParams;
    }

    public void setDeviceMaintainParams(Object deviceMaintainParams) {
        this.deviceMaintainParams = deviceMaintainParams;
    }



    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId;
    }

    public BigDecimal getDeviceMaintainCost() {
        return deviceMaintainCost;
    }

    public void setDeviceMaintainCost(BigDecimal deviceMaintainCost) {
        this.deviceMaintainCost = deviceMaintainCost;
    }

    public String getDeviceMaintainDate() {
        return deviceMaintainDate;
    }

    public void setDeviceMaintainDate(String deviceMaintainDate) {
        this.deviceMaintainDate = deviceMaintainDate;
    }

    public String getDeviceMaintainEmp() {
        return deviceMaintainEmp;
    }

    public void setDeviceMaintainEmp(String deviceMaintainEmp) {
        this.deviceMaintainEmp = deviceMaintainEmp;
    }

    public String getDeviceMaintainEmpId() {
        return deviceMaintainEmpId;
    }

    public void setDeviceMaintainEmpId(String deviceMaintainEmpId) {
        this.deviceMaintainEmpId = deviceMaintainEmpId;
    }

    public String getDeviceMaintainId() {
        return deviceMaintainId;
    }

    public void setDeviceMaintainId(String deviceMaintainId) {
        this.deviceMaintainId = deviceMaintainId;
    }

    public String getDeviceMaintainResult() {
        return deviceMaintainResult;
    }

    public void setDeviceMaintainResult(String deviceMaintainResult) {
        this.deviceMaintainResult = deviceMaintainResult;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
