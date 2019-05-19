package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.FCountCheck;
import com.cskaoyan.bean.Measure;
import com.cskaoyan.service.FCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 01:41
 * 成品计数质检 Controller
 */
@Controller
public class FCountCheckController {

    @Autowired
    FCountCheckService fCountCheckService;

    //新建提交的json对象
    BaseResultVo baseResultVo=new BaseResultVo();

    //返回f_count_check_list
    @RequestMapping("f_count_check/find")
    public String find(){
        return "f_count_check_list";
    }

    //分页查找
    @RequestMapping("f_count_check/list")
    @ResponseBody
    public BaseResultVo<FCountCheck> findFCountCheckList(Integer page, Integer rows){
        int offset = (page - 1) * rows;
        List<FCountCheck> measureList = fCountCheckService.findList(rows,offset);
        baseResultVo.setTotal(fCountCheckService.findAllList().size());
        baseResultVo.setRows(measureList);
        return baseResultVo;
    }
}
