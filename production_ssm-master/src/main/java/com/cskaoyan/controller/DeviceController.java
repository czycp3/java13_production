package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.DeviceJson;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/17 14:57
 * @Version 1.0
 */

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    //封装为json对象的数据
    @Autowired
    DeviceJson deviceJson;

    /*
     * 获取设备台账的json数据对象
     * */
    @RequestMapping("/deviceList/list")
    @ResponseBody
    public DeviceJson deviceList() {
        List<Device> deviceList = deviceService.queryDeviceList();
        deviceJson.setTotal(deviceList.size());
        deviceJson.setRows(deviceList);
        return deviceJson;
    }

    /*
     * 动态获取渲染设备台账json对象的jsp文件
     * */
    @RequestMapping("device/deviceList")
    public String device() {
        return "deviceList";
    }

    /*
    * 通过设备编号查找设备json对象
    * */
    @RequestMapping("/deviceList/search_device_by_deviceId")
    public DeviceJson deviceJson(String searchValue){
        List<Device> deviceList = deviceService.queryDeviceByDeviceId(searchValue);
        deviceJson.setTotal(deviceList.size());
        deviceJson.setRows(deviceList);
        return deviceJson;
    }
}
