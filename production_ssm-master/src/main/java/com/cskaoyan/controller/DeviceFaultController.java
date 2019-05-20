package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/20 17:09
 * @Version 1.0
 */
@Controller
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    /*
    * deviceFault的getDate接口
    * */
    @RequestMapping("/deviceFault/get_data")
    @ResponseBody
    public List<DeviceFault> deviceFaultGetData(){
        return deviceFaultService.deviceFaultGetData();
    }

    /*
    * 显示设备故障首页
    * */
    @RequestMapping("/device/deviceFault")
    public String deviceFaultJsp(){
        return "deviceFault";
    }
    @RequestMapping("/deviceFault/list")
    @ResponseBody
    public BaseResultVo getDeviceFaultList(int rows,int page){
        return deviceFaultService.getDeviceFaultList(rows,page);
    }

    /*
    * 新增设备故障信息
    * */
    @RequestMapping("/deviceFault/add_judge")
    @ResponseBody
    public QueryStatus deviceFaultAddJudge(){
        return new QueryStatus();
    }
    @RequestMapping("/deviceFault/add")
    public String insertDeviceFaultJsp(){
        return "deviceFault_add";
    }
    @RequestMapping("/deviceFault/insert")
    @ResponseBody
    public QueryStatus insertDeviceFault(DeviceFault deviceFault){
        return deviceFaultService.insertDeviceFault(deviceFault);
    }

    /*
    * 编辑设备故障信息
    * */
    @RequestMapping("/deviceFault/edit_judge")
    @ResponseBody
    public QueryStatus deviceFaultEitJudge(){
        return new QueryStatus();
    }
    @RequestMapping("/deviceFault/edit")
    public String deviceFaultEdit(){
        return "deviceFault_edit";
    }
    @RequestMapping(value = {"/deviceFault/update","/deviceFault/update_all"})
    @ResponseBody
    public QueryStatus updateDeviceFault(DeviceFault deviceFault){
        return deviceFaultService.updateDeviceFault(deviceFault);
    }

    /*
    * 删除设备故障
    * */
    @RequestMapping("/deviceFault/delete_judge")
    @ResponseBody
    public QueryStatus deviceFaultDeleteJudge(){
        return new QueryStatus();
    }
    @RequestMapping("/deviceFault/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceFault(String[] ids){
        return deviceFaultService.deleteDeviceFault(ids);
    }

    /*
    * 按设备故障编号查询
    * */
    @RequestMapping("/deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public BaseResultVo searchDeviceFaultById(String searchValue,int rows,int page){
        return deviceFaultService.searchDeviceFaultById(searchValue,rows,page);
    }

    /*
    * 按设备名称查询
    * */
    @RequestMapping("/deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public BaseResultVo searchDeviceFaultByName(String searchValue,int rows,int page){
        return deviceFaultService.searchDeviceFaultByName(searchValue,rows,page);
    }

    /*
    *更改故障描述
    * */
    @RequestMapping("/deviceFault/update_note")
    @ResponseBody
    public QueryStatus updateDeviceNote(String deviceFaultId,String deviceFaultDetail){
        return deviceFaultService.updateDeviceNote(deviceFaultId,deviceFaultDetail);
    }

    @RequestMapping("/deviceFault/get/{deviceFaultId}")
    @ResponseBody
    public DeviceFault getDeviceFaultByDeviceFaultId(@PathVariable("deviceFaultId")String deviceFaultId){
        return deviceFaultService.getDeviceFaultByDeviceFaultId(deviceFaultId);
    }
}
