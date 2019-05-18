package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.service.DeviceTypeService;
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
    @Autowired
    DeviceTypeService deviceTypeService;
    //新建封装为json对象的数据
    BaseResultVo baseResultVo=new BaseResultVo();

    /*
     * 获取设备台账的json数据对象
     * */
    @RequestMapping("/deviceList/list")
    @ResponseBody
    public BaseResultVo deviceList() {
        List<Device> deviceList = deviceService.queryDeviceList();
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }
    /*@RequestMapping("/department/get_data")
    public BaseResultVo getDepartment(){
        List<Department> departmentList = deviceService.queryDepartmentList();
        baseResultVo.setTotal(departmentList.size());
        baseResultVo.setRows(departmentList);
        return baseResultVo;
    }*/

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
    @ResponseBody
    public BaseResultVo getBaseResultVoById(String searchValue){
        List<Device> deviceList = deviceService.queryDeviceByDeviceId(searchValue);
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    /*
    * 通过设备名称查找json对象
    * */
    @RequestMapping("/deviceList/search_device_by_deviceName")
    @ResponseBody
    public BaseResultVo getBaseResultVoByName(String searchValue){
        List<Device> deviceList = deviceService.queryDeviceByDeviceName(searchValue);
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    /*
    * 通过设备类型查找json对象
    * */
    @RequestMapping("/deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public BaseResultVo getBaseResultVoByTypeName(String searchValue){
        List<Device> deviceList = deviceService.queryDeviceByDeviceTypeName(searchValue);
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    /*
    * 新增设备
    * */
    @RequestMapping("/deviceList/add_judge")
    public String addJudge(){
        return "deviceList_add";
    }
    @RequestMapping("/deviceList/add")
    public String addJsp(){
        return "deviceList_add";
    }
    @RequestMapping("/deviceType/get_data")
    public BaseResultVo getDeviceTypeList(){
        List<DeviceType> deviceTypeList = deviceTypeService.getDeviceTypeList();
        baseResultVo.setTotal(deviceTypeList.size());
        baseResultVo.setRows(deviceTypeList);
        return baseResultVo;
    }
    @RequestMapping("/deviceList/insert")
    @ResponseBody
    public QueryStatus addDevice(Device device){
        int num = deviceService.insertDevice(device);
        QueryStatus queryStatus = new QueryStatus();
        if(num==1){
            queryStatus.setStatus(200);
            queryStatus.setMsg("OK");
        }
        return queryStatus;
    }

}
