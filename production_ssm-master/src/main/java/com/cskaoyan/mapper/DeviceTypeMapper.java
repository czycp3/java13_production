package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/18 15:49
 * @Version 1.0
 */
public interface DeviceTypeMapper {
    List<DeviceType> getDeviceTypeList(@Param("rows") int rows, @Param("offset") int offset);

    List<DeviceType> getDeviceTypeById(@Param("deviceTypeId") String searchValue, @Param("rows") int rows, @Param("offset") int offset);

    List<DeviceType> getDeviceTypeByName(@Param("deviceTypeName") String searchValue,@Param("rows") int rows, @Param("offset") int offset);

    DeviceType[] getDeviceTypes();

    DeviceType selectDeviceTypeById(@Param("deviceTypeId") String deviceTypeId);

    int updateDeviceType(@Param("updateDeviceTypeBean") DeviceType deviceType);

    void insertDeviceType(@Param("insertDeviceTypeBean") DeviceType deviceType);

    void deleteDeviceType(@Param("ids") String[] ids);

    int queryTotalDeviceType();

}
