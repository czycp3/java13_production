package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.DeviceMaintainService;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zero
 * @Date: 2019/5/20 20:13
 * @Version 1.0
 */
@Controller
public class DeviceMainTainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/device/deviceMaintain")
    public String deviceMaintainJsp() {
        return "deviceMaintain";
    }

    @RequestMapping("/deviceMaintain/list")
    @ResponseBody
    public BaseResultVo getDeviceMaintainList(int rows, int page) {
        return deviceMaintainService.getDeviceMaintainList(rows, page);
    }

    /*
     * 新增设备维修
     * */
    @RequestMapping("/deviceMaintain/add_judge")
    @ResponseBody
    public QueryStatus deviceMaintainAddJudge() {
        return new QueryStatus();
    }

    @RequestMapping("/deviceMaintain/add")
    public String deviceMaintainAdd() {
        return "deviceMaintain_add";
    }

    @RequestMapping("/deviceMaintain/insert")
    @ResponseBody
    public QueryStatus insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        return deviceMaintainService.insertDeviceMaintain(deviceMaintain);
    }

    /*
     * 编辑设备维修
     * */
    @RequestMapping("/deviceMaintain/edit_judge")
    @ResponseBody
    public QueryStatus deviceMaintainEditJudge() {
        return new QueryStatus();
    }

    @RequestMapping("/deviceMaintain/edit")
    public String deviceMaintainEdit() {
        return "deviceMaintain_edit";
    }

    @RequestMapping("/deviceMaintain/update")
    @ResponseBody
    public QueryStatus UpdateDeviceMaintain(DeviceMaintain deviceMaintain) {
        return deviceMaintainService.UpdateDeviceMaintain(deviceMaintain);
    }

    /*
     * 删除设备维修
     * */
    @RequestMapping("/deviceMaintain/delete_judge")
    @ResponseBody
    public QueryStatus deviceMaintainDeleteJudge() {
        return new QueryStatus();
    }

    @RequestMapping("/deviceMaintain/delete_batch")
    @ResponseBody
    public QueryStatus deleteDeviceMaintain(String[] ids) {
        return deviceMaintainService.deleteDeviceMaintain(ids);
    }

    /*
     * 按设备维修编号查询
     * */
    @RequestMapping("/deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public BaseResultVo searchDeviceMaintainByDeviceMaintainId(String searchValue, int rows, int page) {
        return deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(searchValue, rows, page);
    }

    /*
    * 按故障编号
    * */
    @RequestMapping("/deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public BaseResultVo searchDeviceMaintainBydeviceFaultId(String searchValue, int rows, int page) {
        return deviceMaintainService.searchDeviceMaintainByDeviceFaultId(searchValue, rows, page);
    }

    /*
    *更新备注
    * */
    @RequestMapping("/deviceMaintain/update_note")
    @ResponseBody
    public QueryStatus updateDeviceMaintainNote(String deviceMaintainId, String note){
        return deviceMaintainService.updateDeviceMaintainNote(deviceMaintainId,note);
    }

}
