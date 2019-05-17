package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/17 15:21
 * @Version 1.0
 */
public interface DeviceMapper {
    List<Device> queryDeviceList();

    List<Device> queryDeviceByDeviceId(@Param("deviceId") String searchValue);
}
