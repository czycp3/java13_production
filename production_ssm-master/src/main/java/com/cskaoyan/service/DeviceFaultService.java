package com.cskaoyan.service;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.QueryStatus;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/20 17:10
 * @Version 1.0
 */
public interface DeviceFaultService {
    BaseResultVo getDeviceFaultList(int rows, int page);

    List<DeviceFault> deviceFaultGetData();

    QueryStatus insertDeviceFault(DeviceFault deviceFault);

    QueryStatus updateDeviceFault(DeviceFault deviceFault);

    QueryStatus deleteDeviceFault(String[] deviceFault);

    BaseResultVo searchDeviceFaultById(String searchValue, int rows, int page);

    BaseResultVo searchDeviceFaultByName(String searchValue, int rows, int page);

    QueryStatus updateDeviceNote(String deviceFaultId, String deviceFaultDetail);

    DeviceFault getDeviceFaultByDeviceFaultId(String deviceFaultId);
}


