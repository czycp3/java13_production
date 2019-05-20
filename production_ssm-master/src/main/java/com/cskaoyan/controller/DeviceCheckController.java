package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zero
 * @Date: 2019/5/19 22:46
 * @Version 1.0
 */
@Controller
public class DeviceCheckController {
    @Autowired
    DeviceCheckService deviceCheckService;

    /*
    * 查询设备例检首页
    * */
    @RequestMapping("/device/deviceCheck")
    public String deviceCheck(){
        return "deviceCheck";
    }
    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public BaseResultVo getDeviceCheckList(int rows,int page){
        return deviceCheckService.getDeviceCheckList(rows,page);
    }

    /*
    * 按设备例检编号模糊查询
    * */
    @RequestMapping("/deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public BaseResultVo SearchDeviceCheckById(String searchValue,int rows,int page){
        return deviceCheckService.searchDeviceCheckById(searchValue,rows,page);
    }

    /*
    * 按设备名称模糊查询
    * */
    @RequestMapping("/deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public BaseResultVo SearchDeviceCheckByName(String searchValue,int rows,int page){
        return deviceCheckService.searchDeviceCheckByName(searchValue,rows,page);
    }

    /*
    * 新增设备例检
    * */
    @RequestMapping("/deviceCheck/add_judge")
    @ResponseBody
    public QueryStatus deviceCheckAddJudge(){
        return new QueryStatus();
    }
    @RequestMapping("/deviceCheck/add")
    public String deviceCheckAdd(){
        return "deviceCheck_add";
    }
    @RequestMapping("/deviceCheck/insert")
    @ResponseBody
    public QueryStatus insertDeviceCheck(DeviceCheck deviceCheck){
        return deviceCheckService.insertDeviceCheck(deviceCheck);
    }

    /*
    * 编辑设备例检
    * */
    @RequestMapping("/deviceCheck/edit_judge")
    @ResponseBody
    public QueryStatus deviceCheckEditJudge(){
        return new QueryStatus();
    }
    @RequestMapping("/deviceCheck/edit")
    public String deviceCheckEdit(){
        return "deviceCheck_edit";
    }
    @RequestMapping("/deviceCheck/update")
    @ResponseBody
    public QueryStatus updateDeviceCheck(DeviceCheck deviceCheck){
        return deviceCheckService.updateDeviceCheck(deviceCheck);
    }
    @RequestMapping("/deviceCheck/delete_judge")
    @ResponseBody
    public QueryStatus deviceCheckDeleteJudge(){
        return new QueryStatus();
    }

    /*
    * 删除设备例检
    * */
    @RequestMapping("/deviceCheck/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceCheck(String[] ids){
        return deviceCheckService.deleteDeviceCheck(ids);
    }


}

