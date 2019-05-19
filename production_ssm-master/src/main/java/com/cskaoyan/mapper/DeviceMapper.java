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
    List<Device> queryDeviceList(@Param("rows") int rows,@Param("offset") int offset);

    List<Device> queryDeviceByDeviceId(@Param("deviceId") String searchValue,@Param("rows") int rows,@Param("offset") int offset);

    List<Device> queryDeviceByDeviceName(@Param("deviceName") String searchValue,@Param("rows") int rows,@Param("offset") int offset);

    List<Device> queryDeviceByDeviceTypeName(@Param("deviceTypeName") String searchValue,@Param("rows") int rows,@Param("offset") int offset);

    int insertDevice(@Param("insertDeviceBean") Device device);

    int updateDevice(@Param("updateDeviceBean") Device device);

    int deleteDeviceByIds(@Param("ids") String[] ids);
}
