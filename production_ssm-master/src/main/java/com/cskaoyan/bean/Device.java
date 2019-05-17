package com.cskaoyan.bean;

import java.math.BigDecimal;

/**
 * @Author: zero
 * @Date: 2019/5/17 15:11
 * @Version 1.0
 */
public class Device {
    String deviceId;//设备编号
    String deviceName;//设备名称
    String deviceTypeId;//设备种类的id
    String deviceStatusId;//设备状态的id
    String deviceStatus;//设备状态
    String devicePurchaseDate;//购买日期
    BigDecimal devicePurchasePrice;//购买价格
    String deviceManufactureDate;//出厂日期
    String deviceServiceLife;//使用年限
    String deviceKeeperId;//保管人的id
    String note;//设备介绍
    String deviceIdd;
    String deviceTypeName;//设备种类
    String deviceKeeper;//保管人

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceTypeId='" + deviceTypeId + '\'' +
                ", deviceStatusId='" + deviceStatusId + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", devicePurchaseDate='" + devicePurchaseDate + '\'' +
                ", devicePurchasePrice=" + devicePurchasePrice +
                ", deviceManufactureDate='" + deviceManufactureDate + '\'' +
                ", deviceServiceLife='" + deviceServiceLife + '\'' +
                ", deviceKeeperId='" + deviceKeeperId + '\'' +
                ", note='" + note + '\'' +
                ", deviceIdd='" + deviceIdd + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceKeeper='" + deviceKeeper + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceStatusId() {
        return deviceStatusId;
    }

    public void setDeviceStatusId(String deviceStatusId) {
        this.deviceStatusId = deviceStatusId;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(String devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public BigDecimal getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(BigDecimal devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public String getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(String deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public String getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(String deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }

    public String getDeviceKeeperId() {
        return deviceKeeperId;
    }

    public void setDeviceKeeperId(String deviceKeeperId) {
        this.deviceKeeperId = deviceKeeperId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDeviceIdd() {
        return deviceIdd;
    }

    public void setDeviceIdd(String deviceIdd) {
        this.deviceIdd = deviceIdd;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}
