package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.QueryStatus;

/**
 * @Author: zero
 * @Date: 2019/5/19 22:47
 * @Version 1.0
 */
public interface DeviceCheckService {
    BaseResultVo getDeviceCheckList(int rows, int page);

    BaseResultVo searchDeviceCheckById(String searchValue, int rows, int page);

    BaseResultVo searchDeviceCheckByName(String searchValue, int rows, int page);

    QueryStatus insertDeviceCheck(DeviceCheck deviceCheck);

    QueryStatus updateDeviceCheck(DeviceCheck deviceCheck);

    QueryStatus deleteDeviceCheck(String[] ids);
}
