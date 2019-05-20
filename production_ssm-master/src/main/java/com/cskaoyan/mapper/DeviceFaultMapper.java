package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceFault;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/20 17:15
 * @Version 1.0
 */
public interface DeviceFaultMapper {
    int getTotalDeviceFault();

    List<DeviceFault> getDeviceFaultList(@Param("rows") int rows, @Param("offset") int offset);

    List<DeviceFault> deviceFaultGetData();

    void insertDeviceFault(@Param("insertDeviceFaultBean") DeviceFault deviceFault);

    void updateDeviceFault(@Param("updateDeviceFaultBean") DeviceFault deviceFault);

    void deleteDeviceFault(@Param("ids")String[] ids);

    int getTotalDeviceFaultById(@Param("deviceFaultId") String searchValue);

    List<DeviceFault> searchDeviceFaultById(@Param("deviceFaultId") String searchValue, @Param("rows") int rows, @Param("offset") int offset);

    int getTotalDeviceFaultByName(@Param("deviceFaultName")String searchValue);

    List<DeviceFault> searchDeviceFaultByName(@Param("deviceFaultName") String searchValue, @Param("rows") int rows, @Param("offset") int offset);

    void updateDeviceNote(@Param("deviceFaultId") String deviceFaultId, @Param("deviceFaultDetail") String deviceFaultDetail);


    DeviceFault getDeviceFaultByDeviceFaultId(@Param("deviceFaultId") String deviceFaultId);
}
