package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.DeviceFaultMapper;
import com.cskaoyan.service.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/20 17:10
 * @Version 1.0
 */
@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {
    @Autowired
    DeviceFaultMapper deviceFaultMapper;
    @Override
    public BaseResultVo getDeviceFaultList(int rows,int page) {
        BaseResultVo<DeviceFault> baseResultVo = new BaseResultVo<>();
        int total= deviceFaultMapper.getTotalDeviceFault();
        rows=total<rows?total:rows;
        int offset = (page-1)*rows;
        List<DeviceFault> deviceFaultList = deviceFaultMapper.getDeviceFaultList(rows,offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceFaultList);
        return baseResultVo;
    }

    @Override
    public List<DeviceFault> deviceFaultGetData() {
        return deviceFaultMapper.deviceFaultGetData();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus insertDeviceFault(DeviceFault deviceFault) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceFaultMapper.insertDeviceFault(deviceFault);
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
    public QueryStatus updateDeviceFault(DeviceFault deviceFault) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceFaultMapper.updateDeviceFault(deviceFault);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("编辑失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteDeviceFault(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceFaultMapper.deleteDeviceFault(ids);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public BaseResultVo searchDeviceFaultById(String searchValue, int rows, int page) {
        BaseResultVo<DeviceFault> baseResultVo = new BaseResultVo<>();
        int total= deviceFaultMapper.getTotalDeviceFaultById(searchValue);
        rows=total<rows?total:rows;
        int offset = (page-1)*rows;
        List<DeviceFault> deviceFaultList = deviceFaultMapper.searchDeviceFaultById(searchValue,rows,offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceFaultList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchDeviceFaultByName(String searchValue, int rows, int page) {
        BaseResultVo<DeviceFault> baseResultVo = new BaseResultVo<>();
        int total= deviceFaultMapper.getTotalDeviceFaultByName(searchValue);
        rows=total<rows?total:rows;
        int offset = (page-1)*rows;
        List<DeviceFault> deviceFaultList = deviceFaultMapper.searchDeviceFaultByName(searchValue,rows,offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceFaultList);
        return baseResultVo;
    }

    @Override
    public QueryStatus updateDeviceNote(String deviceFaultId, String deviceFaultDetail) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceFaultMapper.updateDeviceNote(deviceFaultId,deviceFaultDetail);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("更新故障描述失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public DeviceFault getDeviceFaultByDeviceFaultId(String deviceFaultId) {
        return deviceFaultMapper.getDeviceFaultByDeviceFaultId(deviceFaultId);
    }
}


