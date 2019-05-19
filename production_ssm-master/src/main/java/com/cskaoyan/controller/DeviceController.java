package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.service.DeviceTypeService;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.service.impl.EmployeeServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    EmployeeService employeeService;

    /*
     * 获取设备台账的json数据对象
     * */
    @RequestMapping("/deviceList/list")
    @ResponseBody
    public BaseResultVo deviceList(int rows,int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Device> deviceList = deviceService.queryDeviceList(rows,page);
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }


    @RequestMapping("device/deviceList")
    public String device() {
        return "deviceList";
    }

    /*
     * 通过设备编号查找设备json对象
     * */
    @RequestMapping("/deviceList/search_device_by_deviceId")
    @ResponseBody
    public BaseResultVo getBaseResultVoById(String searchValue,int rows,int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Device> deviceList = deviceService.queryDeviceByDeviceId(searchValue,rows,page);
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    /*
     * 通过设备名称查找json对象
     * */
    @RequestMapping("/deviceList/search_device_by_deviceName")
    @ResponseBody
    public BaseResultVo getBaseResultVoByName(String searchValue,int rows,int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Device> deviceList = deviceService.queryDeviceByDeviceName(searchValue,rows,page);
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    /*
     * 通过设备类型查找json对象
     * */
    @RequestMapping("/deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public BaseResultVo getBaseResultVoByTypeName(String searchValue,int rows,int page) {
        BaseResultVo baseResultVo = new BaseResultVo();
        List<Device> deviceList = deviceService.queryDeviceByDeviceTypeName(searchValue,rows,page);
        baseResultVo.setTotal(deviceList.size());
        baseResultVo.setRows(deviceList);
        return baseResultVo;
    }

    /*
     * 新增设备
     * */
    @RequestMapping("/deviceList/add_judge")
    public String addJudge() {
        return "deviceList_add";
    }

    @RequestMapping("/deviceList/add")
    public String addJsp() {
        return "deviceList_add";
    }

    @RequestMapping("/deviceType/get_data")
    @ResponseBody
    public DeviceType[] getDeviceTypeList() {
        DeviceType[] deviceTypes = deviceTypeService.getDeviceTypes();
        return deviceTypes;
    }

    @RequestMapping("/deviceList/insert")
    @ResponseBody
    public QueryStatus addDevice(Device device) {
        QueryStatus queryStatus = deviceService.insertDevice(device);
        return queryStatus;
    }

    /*
     * 编辑设备
     * */
    @RequestMapping("/deviceList/edit")
    public String deviceEdit() {
        return "deviceList_edit";
    }

    @RequestMapping("/deviceList/edit_judge")
    @ResponseBody
    public BaseResultVo editJudge() {
        return new BaseResultVo();
    }

    @RequestMapping("/deviceList/update")
    @ResponseBody
    public QueryStatus updateDevice(Device device) {
        QueryStatus queryStatus = deviceService.updateDevice(device);
        return queryStatus;
    }

    /*
     * 删除设备
     * */
    @RequestMapping("/deviceList/delete_judge")
    @ResponseBody
    public BaseResultVo deleteJudge() {
        return new BaseResultVo();
    }

    @RequestMapping("/deviceList/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceByIds(String[] ids) {
        QueryStatus queryStatus = deviceService.deleteDeviceByIds(ids);
        return queryStatus;
    }


    @RequestMapping("/employee/get/{deviceKeeperId}")
    @ResponseBody
    public Employee selectEmployeeById(@PathVariable("deviceKeeperId")String deviceKeeperId){
        Employee employee = employeeService.selectEmployeeById(deviceKeeperId);
        return employee;
    }


}
