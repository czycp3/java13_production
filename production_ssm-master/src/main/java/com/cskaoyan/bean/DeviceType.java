package com.cskaoyan.bean;

/**
 * @Author: zero
 * @Date: 2019/5/18 15:40
 * @Version 1.0
 */
public class DeviceType {
    String deviceTypeId;//设备种类编号
    String deviceTypeIdd;
    String deviceTypeModel;//型号
    String deviceTypeName;//设备种类名称
    String deviceTypeProducer;//生产商
    int deviceTypeQuantity;//台数
    String deviceTypeSpec;//规格
    String deviceTypeSupplier;//供应商
    String deviceTypeWarranty;//保修期

    @Override
    public String toString() {
        return "DeviceType{" +
                "deviceTypeId='" + deviceTypeId + '\'' +
                ", deviceTypeIdd='" + deviceTypeIdd + '\'' +
                ", deviceTypeModel='" + deviceTypeModel + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                ", deviceTypeProducer='" + deviceTypeProducer + '\'' +
                ", deviceTypeQuantity=" + deviceTypeQuantity +
                ", deviceTypeSpec='" + deviceTypeSpec + '\'' +
                ", deviceTypeSupplier='" + deviceTypeSupplier + '\'' +
                ", deviceTypeWarranty='" + deviceTypeWarranty + '\'' +
                '}';
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceTypeIdd() {
        return deviceTypeIdd;
    }

    public void setDeviceTypeIdd(String deviceTypeIdd) {
        this.deviceTypeIdd = deviceTypeIdd;
    }

    public String getDeviceTypeModel() {
        return deviceTypeModel;
    }

    public void setDeviceTypeModel(String deviceTypeModel) {
        this.deviceTypeModel = deviceTypeModel;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceTypeProducer() {
        return deviceTypeProducer;
    }

    public void setDeviceTypeProducer(String deviceTypeProducer) {
        this.deviceTypeProducer = deviceTypeProducer;
    }

    public int getDeviceTypeQuantity() {
        return deviceTypeQuantity;
    }

    public void setDeviceTypeQuantity(int deviceTypeQuantity) {
        this.deviceTypeQuantity = deviceTypeQuantity;
    }

    public String getDeviceTypeSpec() {
        return deviceTypeSpec;
    }

    public void setDeviceTypeSpec(String deviceTypeSpec) {
        this.deviceTypeSpec = deviceTypeSpec;
    }

    public String getDeviceTypeSupplier() {
        return deviceTypeSupplier;
    }

    public void setDeviceTypeSupplier(String deviceTypeSupplier) {
        this.deviceTypeSupplier = deviceTypeSupplier;
    }

    public String getDeviceTypeWarranty() {
        return deviceTypeWarranty;
    }

    public void setDeviceTypeWarranty(String deviceTypeWarranty) {
        this.deviceTypeWarranty = deviceTypeWarranty;
    }
}
