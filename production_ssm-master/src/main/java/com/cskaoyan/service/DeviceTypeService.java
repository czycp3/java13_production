package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceType;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/18 15:46
 * @Version 1.0
 */
public interface DeviceTypeService {
    List<DeviceType> getDeviceTypeList();

    List<DeviceType> getDeviceTypeById(String searchValue);

    List<DeviceType> getDeviceTypeByName(String searchValue);

    DeviceType[] getDeviceTypes();
}
