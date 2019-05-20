package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.FCountCheck;
import com.cskaoyan.bean.Measure;
import com.cskaoyan.bean.QueryStatus;
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


    //增加
    @RequestMapping("/fCountCheck/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    //增加
    @RequestMapping("f_count_check/add")
    public String add(){
        return "f_count_check_add";
    }


    //增加
    @RequestMapping("/f_count_check/insert")
    @ResponseBody
    public QueryStatus insert(FCountCheck fCountCheck){
        return fCountCheckService.insert(fCountCheck);
    }

    //修改全部信息
    @RequestMapping("/fCountCheck/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    //修改全部信息
    @RequestMapping("/f_count_check/edit")
    public String edit(){
        return "f_count_check_edit";
    }

    //修改全部信息
    @RequestMapping("/f_count_check/update_all")
    @ResponseBody
    public QueryStatus update_all(FCountCheck fCountCheck) {
        return fCountCheckService.update_all(fCountCheck);
    }

    //修改note
    @RequestMapping("/f_count_check/update_note")
    @ResponseBody
    public QueryStatus update_note(String fCountCheckId, String note){
        return fCountCheckService.update_note(fCountCheckId,note);
    }

    //删除
    @RequestMapping("/fCountCheck/delete_judge")
    @ResponseBody
    public String delete_judgee(){
        return "";
    }

    //删除
    @RequestMapping("/f_count_check/delete_batch")
    @ResponseBody
    public QueryStatus delete_batch(String[] ids){
        return fCountCheckService.delete_batch(ids);
    }

    //根据id查询
    @RequestMapping("/f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public BaseResultVo<FCountCheck> searchfMeasureCheckByfMeasureCheckId(String searchValue,Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<FCountCheck> unqualifyList = fCountCheckService.searchfMeasureCheckByfMeasureCheckId(searchValue,rows,offset);
        baseResultVo.setTotal(fCountCheckService.searchAllfMeasureCheckByfMeasureCheckId(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }


    //根据订单id查询
    @RequestMapping("/f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public BaseResultVo<FCountCheck> searchfMeasureCheckByOrderId(String searchValue,Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<FCountCheck> unqualifyList = fCountCheckService.searchfMeasureCheckByOrderId(searchValue,rows,offset);
        baseResultVo.setTotal(fCountCheckService.searchAllfMeasureCheckByOrderId(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }

}
