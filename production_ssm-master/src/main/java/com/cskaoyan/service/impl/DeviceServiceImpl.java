package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/17 15:20
 * @Version 1.0
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> queryDeviceList() {
        List<Device> deviceList = deviceMapper.queryDeviceList();

        return deviceList;
    }

    @Override
    public List<Device> queryDeviceByDeviceId(String searchValue) {
        List<Device> deviceList = deviceMapper.queryDeviceByDeviceId(searchValue);
        return deviceList;
    }

    @Override
    public List<Device> queryDeviceByDeviceName(String searchValue) {
        List<Device> deviceList = deviceMapper.queryDeviceByDeviceName(searchValue);
        return deviceList;
    }

    @Override
    public List<Device> queryDeviceByDeviceTypeName(String searchValue) {
        List<Device> deviceList = deviceMapper.queryDeviceByDeviceTypeName(searchValue);
        return deviceList;
    }

    @Override
    public int insertDevice(Device device) {
        int num = deviceMapper.insertDevice(device);
        return 0;
    }
}
