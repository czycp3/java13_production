package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/18 15:46
 * @Version 1.0
 */
public interface DeviceTypeService {
    BaseResultVo getDeviceTypeList(int rows, int page);

    BaseResultVo getDeviceTypeById(String searchValue, int rows, int page);

    BaseResultVo getDeviceTypeByName(String searchValue, int rows, int page);

    DeviceType[] getDeviceTypes();

    DeviceType selectDeviceTypeById(String deviceTypeId);

    QueryStatus updateDeviceType(DeviceType deviceType);

    QueryStatus insertDeviceType(DeviceType deviceType);

    QueryStatus deleteDeviceType(String[] ids);

}
