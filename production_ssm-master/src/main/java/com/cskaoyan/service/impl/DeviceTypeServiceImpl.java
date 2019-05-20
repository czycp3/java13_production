package com.cskaoyan.service.impl;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/18 15:48
 * @Version 1.0
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    QueryStatus queryStatus = new QueryStatus();

    Logger logger;
    @Override
    public BaseResultVo getDeviceTypeList(int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceTypeMapper.queryTotalDeviceType();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<DeviceType> deviceList = deviceTypeMapper.getDeviceTypeList(rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo getDeviceTypeById(String searchValue,int rows,int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceTypeMapper.queryTotalDeviceType();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<DeviceType> deviceList = deviceTypeMapper.getDeviceTypeById(searchValue,rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo getDeviceTypeByName(String searchValue,int rows,int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceTypeMapper.queryTotalDeviceType();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<DeviceType> deviceList = deviceTypeMapper.getDeviceTypeByName(searchValue,rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public DeviceType[] getDeviceTypes() {
        DeviceType[] deviceTypes = deviceTypeMapper.getDeviceTypes();
        return deviceTypes;
    }

    @Override
    public DeviceType selectDeviceTypeById(String deviceTypeId) {
        DeviceType deviceType = deviceTypeMapper.selectDeviceTypeById(deviceTypeId);

        return deviceType;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus updateDeviceType(DeviceType deviceType) {
        try {
            int i = deviceTypeMapper.updateDeviceType(deviceType);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("编辑失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public QueryStatus insertDeviceType(DeviceType deviceType) {
        try {
            deviceTypeMapper.insertDeviceType(deviceType);
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
    public QueryStatus deleteDeviceType(String[] ids) {
        try {
            deviceTypeMapper.deleteDeviceType(ids);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }catch (Exception e){
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败，请重新尝试");
        }
        return queryStatus;
    }
}
