package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.QueryStatus;

/**
 * @Author: zero
 * @Date: 2019/5/20 20:16
 * @Version 1.0
 */
public interface DeviceMaintainService {
    BaseResultVo getDeviceMaintainList(int rows, int page);

    QueryStatus insertDeviceMaintain(DeviceMaintain deviceMaintain);

    QueryStatus UpdateDeviceMaintain(DeviceMaintain deviceMaintain);

    QueryStatus deleteDeviceMaintain(String[] ids);

    BaseResultVo searchDeviceMaintainByDeviceMaintainId(String searchValue, int rows, int page);

    BaseResultVo searchDeviceMaintainByDeviceFaultId(String searchValue, int rows, int page);

    QueryStatus updateDeviceMaintainNote(String deviceMaintainId, String note);
}
