package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Device;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/17 15:09
 * @Version 1.0
 */
public interface DeviceService {
    List<Device> queryDeviceList();

    List<Device> queryDeviceByDeviceId(String searchValue);

    List<Device> queryDeviceByDeviceName(String searchValue);

    List<Device> queryDeviceByDeviceTypeName(String searchValue);

    int insertDevice(Device device);

    List<Department> getDepartment();
}
