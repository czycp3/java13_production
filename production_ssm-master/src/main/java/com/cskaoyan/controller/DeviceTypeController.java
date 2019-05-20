package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
    public BaseResultVo queryDeviceTypeList(int rows,int page){
        return deviceTypeService.getDeviceTypeList(rows,page);
    }

    /*
    * 通过设备种类编号模糊查询设备种类
    * */
    @RequestMapping("/deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public BaseResultVo queryDeviceTypeById(String searchValue,int rows,int page){
        return deviceTypeService.getDeviceTypeById(searchValue,rows,page);
    }

    /*
    * 通过设备种类名称模糊查询设备种类
    * */
    @RequestMapping("/deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public BaseResultVo queryDeviceTypeByName(String searchValue,int rows,int page){
        return deviceTypeService.getDeviceTypeByName(searchValue,rows,page);
    }

    @RequestMapping("/deviceType/edit_judge")
    @ResponseBody
    public BaseResultVo deviceTypeEditJudge(){
        return new BaseResultVo();
    }

    /*
    * 编辑deviceType
    * */
    @RequestMapping(value = {"/deviceType/update_all","/deviceType/update"})
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

    /*
    * 新增设备类型
    * */
    @RequestMapping("/deviceType/add_judge")
    @ResponseBody
    public BaseResultVo deviceTypeAddJudge(){
        return new BaseResultVo();
    }

    @RequestMapping("/deviceType/add")
    public String deviceTypeAdd(){
        return "deviceType_add";
    }

    @RequestMapping("/deviceType/insert")
    @ResponseBody
    public QueryStatus insertDeviceType(DeviceType deviceType){
        return deviceTypeService.insertDeviceType(deviceType);
    }

    /*
    * 编辑设备种类
    * */
    @RequestMapping("/deviceType/edit")
    public String deviceTypeEdit(){
        return "deviceType_edit";
    }

    /*
    * 批量删除设备种类
    * */
    @RequestMapping("/deviceType/delete_judge")
    @ResponseBody
    public BaseResultVo deviceTypeDeleteJudge(){
        return new BaseResultVo();
    }
    @RequestMapping("/deviceType/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceType(String[] ids){
        return deviceTypeService.deleteDeviceType(ids);
    }
}

