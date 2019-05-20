package com.cskaoyan.bean;

/**
 * @Author: zero
 * @Date: 2019/5/20 17:05
 * @Version 1.0
 */
public class DeviceFault {
    String deviceFaultCause;
    String deviceFaultDate;
    String deviceFaultDetail;
    String deviceFaultId;
    String deviceFaultMaintenance;
    String deviceId;
    String deviceName;
    String deviceParams;

    public String getDeviceParams() {
        return deviceParams;
    }

    public void setDeviceParams(String deviceParams) {
        this.deviceParams = deviceParams;
    }

    @Override
    public String toString() {
        return "DeviceFault{" +
                "deviceFaultCause='" + deviceFaultCause + '\'' +
                ", deviceFaultDate='" + deviceFaultDate + '\'' +
                ", deviceFaultDetail='" + deviceFaultDetail + '\'' +
                ", deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceFaultMaintenance='" + deviceFaultMaintenance + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceParams='" + deviceParams + '\'' +
                '}';
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause;
    }

    public String getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(String deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail;
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId;
    }

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance;
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
}
