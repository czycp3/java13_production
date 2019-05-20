package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;
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
    public List<DeviceType> getDeviceTypeList(int rows, int page) {
        int offset = (page-1)*rows;
        List<DeviceType> deviceTypeList = deviceTypeMapper.getDeviceTypeList(rows,offset);
        logger = this.logger.getLogger(this.getClass());
        logger.info(deviceTypeList);
        return deviceTypeList;
    }

    @Override
    public List<DeviceType> getDeviceTypeById(String searchValue,int rows,int page) {
        int offset = (page-1)*rows;
        List<DeviceType> deviceTypeList = deviceTypeMapper.getDeviceTypeById(searchValue,rows,offset);
        logger = this.logger.getLogger(this.getClass());
        logger.info(deviceTypeList);
        return deviceTypeList;
    }

    @Override
    public List<DeviceType> getDeviceTypeByName(String searchValue,int rows,int page) {
        int offset = (page-1)*rows;
        List<DeviceType> deviceTypeList = deviceTypeMapper.getDeviceTypeByName(searchValue,rows,offset);
        logger = this.logger.getLogger(this.getClass());
        logger.info(deviceTypeList);
        return deviceTypeList;
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
