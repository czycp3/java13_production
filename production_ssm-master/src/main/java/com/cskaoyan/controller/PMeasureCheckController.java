package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.PMeasureCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.PMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 22:38
 */
@Controller
public class PMeasureCheckController {

    @Autowired
    PMeasureCheckService pMeasureCheckService;

    //新建提交的json对象
    BaseResultVo baseResultVo=new BaseResultVo();

    //返回list
    @RequestMapping("/p_measure_check/find")
    public String find(){
        return "p_measure_check_list";
    }


    //分页查找
    @RequestMapping("/p_measure_check/list")
    @ResponseBody
    public BaseResultVo<PMeasureCheck> findList(Integer page, Integer rows){
        int offset = (page - 1) * rows;
        List<PMeasureCheck> list = pMeasureCheckService.findList(rows,offset);
        baseResultVo.setTotal(pMeasureCheckService.findAllList().size());
        baseResultVo.setRows(list);
        return baseResultVo;
    }




    //增加
    @RequestMapping("/pMeasureCheck/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    //增加
    @RequestMapping("/p_measure_check/add")
    public String add(){
        return "p_measure_check_add";
    }

    //增加
    @RequestMapping("/p_measure_check/insert")
    @ResponseBody
    public QueryStatus insert(PMeasureCheck pMeasureCheck){
        return pMeasureCheckService.insert(pMeasureCheck);
    }

    //修改全部信息
    @RequestMapping("/pMeasureCheck/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    //修改全部信息
    @RequestMapping("/p_measure_check/edit")
    public String edit(){
        return "p_measure_check_edit";
    }

    //修改全部信息
    @RequestMapping("/p_measure_check/update_all")
    @ResponseBody
    public QueryStatus updateAll(PMeasureCheck pMeasureCheck) {
        return pMeasureCheckService.updateAll(pMeasureCheck);
    }

    //修改note
    @RequestMapping("/p_measure_check/update_note")
    @ResponseBody
    public QueryStatus update_note(String pMeasureCheckId, String note){
        return pMeasureCheckService.updateNote(pMeasureCheckId,note);
    }

    //删除
    @RequestMapping("/pMeasureCheck/delete_judge")
    @ResponseBody
    public String deleteJudgee(){
        return "";
    }

    //删除
    @RequestMapping("/p_measure_check/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids){
        return pMeasureCheckService.deleteBatch(ids);
    }

    //根据id查询
    @RequestMapping("/p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public BaseResultVo<PMeasureCheck> searchById(String searchValue,Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<PMeasureCheck> unqualifyList = pMeasureCheckService.searchById(searchValue,rows,offset);
        baseResultVo.setTotal(pMeasureCheckService.searchAllById(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }

}
