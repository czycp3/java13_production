package com.cskaoyan.service.impl;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/17 15:20
 * @Version 1.0
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public BaseResultVo queryDeviceList(int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceMapper.queryTotalDevice();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Device> deviceList = deviceMapper.queryDeviceList(rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo queryDeviceByDeviceId(String searchValue, int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceMapper.queryTotalDevice();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Device> deviceList = deviceMapper.queryDeviceByDeviceId(searchValue,rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo queryDeviceByDeviceName(String searchValue, int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceMapper.queryTotalDevice();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Device> deviceList = deviceMapper.queryDeviceByDeviceName(searchValue,rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public BaseResultVo queryDeviceByDeviceTypeName(String searchValue, int rows, int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        int total = deviceMapper.queryTotalDevice();
        rows = total < rows ? total : rows;
        int offset = (page - 1) * rows;
        List<Device> deviceList = deviceMapper.queryDeviceByDeviceTypeName(searchValue,rows, offset);
        baseResultVo.setTotal(total);
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    @Override
    public QueryStatus insertDevice(Device device) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMapper.insertDevice(device);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("插入失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public QueryStatus updateDevice(Device device) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMapper.updateDevice(device);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("编辑失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public QueryStatus deleteDeviceByIds(String[] ids) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMapper.deleteDeviceByIds(ids);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败，请重新尝试");
        }
        return queryStatus;
    }

    @Override
    public List<Device> getDeviceList() {
        List<Device> deviceList = deviceMapper.getDeviceList();
        return deviceList;
    }

    @Override
    public Device selectDeviceById(String deviceId) {
        return deviceMapper.selectDeviceById(deviceId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public QueryStatus updateDeviceList(Device device) {
        QueryStatus queryStatus = new QueryStatus();
        try {
            deviceMapper.updateDevice(device);
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        } catch (Exception e) {
            queryStatus.setStatus(0);
            queryStatus.setMsg("删除失败，请重新尝试");
        }
        return queryStatus;
    }
}
