package com.cskaoyan.service;

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

}
