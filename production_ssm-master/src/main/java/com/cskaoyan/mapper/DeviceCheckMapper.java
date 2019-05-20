package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/19 22:52
 * @Version 1.0
 */
public interface DeviceCheckMapper {
    List<DeviceCheck> getDeviceCheckList(@Param("rows") int rows, @Param("offset") int offset);

    List<DeviceCheck> searchDeviceCheckById(@Param("deviceCheckId") String searchValue, @Param("rows") int rows, @Param("offset") int offset);

    List<DeviceCheck> searchDeviceCheckByName(@Param("deviceCheckName")String searchValue, @Param("rows")int rows, @Param("offset")int offset);

    void insertDeviceCheck(@Param("insertDeviceCheckBean") DeviceCheck deviceCheck);

    void updateDeviceCheck(@Param("updateDeviceCheckBean") DeviceCheck deviceCheck);

    void deleteDeviceCheck(@Param("ids") String[] ids);

    int queryTotalDeviceCheck();

    int queryTotalDeviceCheckById(@Param("deviceCheckId") String searchValue);

    int queryTotalDeviceCheckByName(@Param("deviceName")String searchValue);
}
