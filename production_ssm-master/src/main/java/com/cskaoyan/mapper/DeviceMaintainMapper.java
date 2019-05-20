package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.DeviceMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/20 20:19
 * @Version 1.0
 */
public interface DeviceMaintainMapper {
    int getTotalDeviceMaintain();

    List<DeviceFault> getDeviceMaintainList(@Param("rows") int rows, @Param("offset") int offset);

    void insertDeviceMaintain(@Param("insertDeviceMaintain") DeviceMaintain deviceMaintain);

    void UpdateDeviceMaintain(@Param("updateDeviceMaintain") DeviceMaintain deviceMaintain);

    void deleteDeviceMaintain(@Param("ids") String[] ids);

    int getTotalDeviceMaintainByDeviceMaintainId(@Param("deviceMaintainId")String searchValue);

    List<DeviceFault> searchDeviceMaintainByDeviceMaintainId(@Param("deviceMaintainId") String searchValue, @Param("rows") int rows, @Param("offset") int offset);

    int getTotalDeviceMaintainByDeviceFaultId(@Param("deviceFaultId") String searchValue);

    List<DeviceFault> searchDeviceMaintainByDeviceFaultId(@Param("deviceFaultId") String searchValue, @Param("rows") int rows, @Param("offset") int offset);

    void updateDeviceMaintainNote(@Param("deviceMaintainId") String deviceMaintainId, @Param("note") String note);
}
