package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Measure;
import com.cskaoyan.bean.Unqualify;
import com.cskaoyan.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-18 19:34
 * 成品计量质检的contriller
 */
@Controller
public class MeasureController {

    @Autowired
    MeasureService measureService;

    //新建提交的json对象
    BaseResultVo baseResultVo=new BaseResultVo();

    //返回成品计量质检的表
    @RequestMapping("measure/find")
    public String find(){
        return "measurement_list";
    }

    /**
     * 通过传入page和rows来进行分页查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("measure/list")
    @ResponseBody
    public BaseResultVo<Measure> findMeasureList(Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<Measure> measureList = measureService.findList(rows,offset);
        baseResultVo.setTotal(measureService.findAllList().size());
        baseResultVo.setRows(measureList);

        return baseResultVo;
    }



}
