package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/17 15:09
 * @Version 1.0
 */
public interface DeviceService {
    BaseResultVo queryDeviceList(int rows, int page);

    BaseResultVo queryDeviceByDeviceId(String searchValue, int rows, int page);

    BaseResultVo queryDeviceByDeviceName(String searchValue,int rows,int page);

    BaseResultVo queryDeviceByDeviceTypeName(String searchValue,int rows,int page);

    QueryStatus insertDevice(Device device);

    QueryStatus updateDevice(Device device);

    QueryStatus deleteDeviceByIds(String[] ids);

    List<Device> getDeviceList();

    Device selectDeviceById(String deviceId);

    QueryStatus updateDeviceList(Device device);
}
