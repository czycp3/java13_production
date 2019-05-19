package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/18 16:37
 * @Version 1.0
 */
@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;
    //新建提交的json对象
    BaseResultVo baseResultVo=new BaseResultVo();

    @RequestMapping("/device/deviceType")
    public String getJsp(){
        return "deviceType";
    }
    @RequestMapping("/deviceType/list")
    @ResponseBody
    public BaseResultVo queryDeviceTypeList(){
        List<DeviceType> deviceTypeList = deviceTypeService.getDeviceTypeList();
        baseResultVo.setTotal(deviceTypeList.size());
        baseResultVo.setRows(deviceTypeList);
        return baseResultVo;
    }

    /*
    * 通过设备种类编号模糊查询设备种类
    * */
    @RequestMapping("/deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public BaseResultVo queryDeviceTypeById(String searchValue){
        List<DeviceType> deviceTypeList = deviceTypeService.getDeviceTypeById(searchValue);
        baseResultVo.setTotal(deviceTypeList.size());
        baseResultVo.setRows(deviceTypeList);
        return baseResultVo;
    }

    /*
    * 通过设备种类名称模糊查询设备种类
    * */
    @RequestMapping("/deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public BaseResultVo queryDeviceTypeByName(String searchValue){
        List<DeviceType> deviceTypeList = deviceTypeService.getDeviceTypeByName(searchValue);
        baseResultVo.setTotal(deviceTypeList.size());
        baseResultVo.setRows(deviceTypeList);
        return baseResultVo;
    }

    @RequestMapping("/deviceType/edit_judge")
    @ResponseBody
    public BaseResultVo deviceTypeEditJudge(){
        return new BaseResultVo();
    }

    /*
    * 编辑deviceType
    * */
    @RequestMapping("/deviceType/update_all")
    @ResponseBody
    public QueryStatus updateDeviceType(DeviceType deviceType){
        QueryStatus queryStatus = deviceTypeService.updateDeviceType(deviceType);
        return queryStatus;

    }


    /*
     * 查询其他表的详情
     * */
    @RequestMapping("/deviceType/get/{deviceTypeId}")
    @ResponseBody
    public DeviceType selectDeviceTypeById(@PathVariable("deviceTypeId")String deviceTypeId){
        DeviceType deviceType =deviceTypeService.selectDeviceTypeById(deviceTypeId);
        return deviceType;
    }
}

