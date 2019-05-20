package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.DeviceCheckMapper;
import com.cskaoyan.service.DeviceCheckService;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/19 22:48
 * @Version 1.0
 */
@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Override
    public BaseResultVo getDeviceCheckList(int rows,int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceCheckMapper.queryTotalDeviceCheck();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<DeviceCheck> deviceList = deviceCheckMapper.getDeviceCheckList(rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchDeviceCheckById(String searchValue, int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceCheckMapper.queryTotalDeviceCheckById(searchValue);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<DeviceCheck> deviceList = deviceCheckMapper.searchDeviceCheckById(searchValue,rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo searchDeviceCheckByName(String searchValue, int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceCheckMapper.queryTotalDeviceCheckByName(searchValue);
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<DeviceCheck> deviceList = deviceCheckMapper.searchDeviceCheckByName(searchValue,rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus insertDeviceCheck(DeviceCheck deviceCheck) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceCheckMapper.insertDeviceCheck(deviceCheck);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("添加失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus updateDeviceCheck(DeviceCheck deviceCheck) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceCheckMapper.updateDeviceCheck(deviceCheck);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("添加失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus deleteDeviceCheck(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceCheckMapper.deleteDeviceCheck(ids);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("添加失败，请重新尝试");
        }
        return queryStatus;
    }
}
