package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.DeviceMaintainMapper;
import com.cskaoyan.service.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/20 20:17
 * @Version 1.0
 */
@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;
    @Override
    public BaseResultVo getDeviceMaintainList(int rows, int page) {
        BaseResultVo<DeviceFault> baseResultVo = new BaseResultVo<>();
        int total= deviceMaintainMapper.getTotalDeviceMaintain();
        rows=total<rows?total:rows;
        int offset = (page-1)*rows;
        List<DeviceFault> deviceFaultList = deviceMaintainMapper.getDeviceMaintainList(rows,offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceFaultList);
        return baseResultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMaintainMapper.insertDeviceMaintain(deviceMaintain);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("插入失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus UpdateDeviceMaintain(DeviceMaintain deviceMaintain) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMaintainMapper.UpdateDeviceMaintain(deviceMaintain);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteDeviceMaintain(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMaintainMapper.deleteDeviceMaintain(ids);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public BaseResultVo searchDeviceMaintainByDeviceMaintainId(String searchValue, int rows, int page) {
        BaseResultVo<DeviceFault> baseResultVo = new BaseResultVo<>();
        int total= deviceMaintainMapper.getTotalDeviceMaintainByDeviceMaintainId(searchValue);
        rows=total<rows?total:rows;
        int offset = (page-1)*rows;
        List<DeviceFault> deviceFaultList = deviceMaintainMapper.searchDeviceMaintainByDeviceMaintainId(searchValue,rows,offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceFaultList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchDeviceMaintainByDeviceFaultId(String searchValue, int rows, int page) {
        BaseResultVo<DeviceFault> baseResultVo = new BaseResultVo<>();
        int total= deviceMaintainMapper.getTotalDeviceMaintainByDeviceFaultId(searchValue);
        rows=total<rows?total:rows;
        int offset = (page-1)*rows;
        List<DeviceFault> deviceFaultList = deviceMaintainMapper.searchDeviceMaintainByDeviceFaultId(searchValue,rows,offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceFaultList);
        return baseResultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus updateDeviceMaintainNote(String deviceMaintainId, String note) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMaintainMapper.updateDeviceMaintainNote(deviceMaintainId,note);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新失败，请重新尝试");
        }
        return queryStatus;
    }
}
