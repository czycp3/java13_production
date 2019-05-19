package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Measure;
import com.cskaoyan.bean.QueryStatus;
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



    //增加
    @RequestMapping("fMeasureCheck/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    //增加
    @RequestMapping("measure/add")
    public String add(){
        return "measurement_add";
    }


    //增加
    @RequestMapping(" measure/insert")
    @ResponseBody
    public QueryStatus insert(Measure measure){
        return measureService.insert(measure);
    }

    //修改全部信息
    @RequestMapping("fMeasureCheck/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    //修改全部信息
    @RequestMapping("/measure/edit")
    public String edit(){
        return "measurement_edit";
    }

    //修改全部信息
    @RequestMapping("measure/update_all")
    @ResponseBody
    public QueryStatus update_all(Measure measure) {
        return measureService.update_all(measure);
    }


    //修改note
    @RequestMapping("/measure/update_note")
    @ResponseBody
    public QueryStatus update_note(String fMeasureCheckId, String note){
        return measureService.update_note(fMeasureCheckId,note);
    }

    //删除
    @RequestMapping("/fMeasureCheck/delete_judge")
    @ResponseBody
    public String delete_judgee(){
        return "";
    }

    //删除
    @RequestMapping("/measure/delete_batch")
    @ResponseBody
    public QueryStatus delete_batch(String[] ids){
        return measureService.delete_batch(ids);
    }

    //根据id查询
    @RequestMapping("/measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public BaseResultVo<Measure> searchfMeasureCheckByfMeasureCheckId(String searchValue,Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<Measure> unqualifyList = measureService.searchfMeasureCheckByfMeasureCheckId(searchValue,rows,offset);
        baseResultVo.setTotal(measureService.searchAllfMeasureCheckByfMeasureCheckId(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }


    //根据订单id查询
    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public BaseResultVo<Measure> searchfMeasureCheckByOrderId(String searchValue,Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<Measure> unqualifyList = measureService.searchfMeasureCheckByOrderId(searchValue,rows,offset);
        baseResultVo.setTotal(measureService.searchAllfMeasureCheckByOrderId(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }



}
