package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/18 15:48
 * @Version 1.0
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    Logger logger;
    @Override
    public List<DeviceType> getDeviceTypeList() {
        List<DeviceType> deviceTypeList = deviceTypeMapper.getDeviceTypeList();
        logger = this.logger.getLogger(this.getClass());
        logger.info(deviceTypeList);
        return deviceTypeList;
    }
}
