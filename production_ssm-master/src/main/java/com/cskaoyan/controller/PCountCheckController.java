package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.PCountCheck;
import com.cskaoyan.bean.PMeasureCheck;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.service.PCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 00:27
 */

@Controller
public class PCountCheckController {
    @Autowired
    PCountCheckService pCountCheckService;

    //新建提交的json对象
    BaseResultVo baseResultVo = new BaseResultVo();

    //返回list
    @RequestMapping("/p_count_check/find")
    public String find() {
        return "p_count_check_list";
    }


    //分页查找
    @RequestMapping("/p_count_check/list")
    @ResponseBody
    public BaseResultVo<PCountCheck> findList(Integer page, Integer rows) {
        int offset = (page - 1) * rows;
        List<PCountCheck> list = pCountCheckService.findList(rows, offset);
        baseResultVo.setTotal(pCountCheckService.findAllList().size());
        baseResultVo.setRows(list);
        return baseResultVo;
    }


    //增加
    @RequestMapping("/pCountCheck/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    //增加
    @RequestMapping("/p_count_check/add")
    public String add() {
        return "p_count_check_add";
    }

    //增加
    @RequestMapping("/p_count_check/insert")
    @ResponseBody
    public QueryStatus insert(PCountCheck pCountCheck) {
        return pCountCheckService.insert(pCountCheck);
    }

    //修改全部信息
    @RequestMapping("/pCountCheck/edit_judge")
    @ResponseBody
    public String edit_judge() {
        return "";
    }

    //修改全部信息
    @RequestMapping("/p_count_check/edit")
    public String edit() {
        return "p_count_check_edit";
    }

    //修改全部信息
    @RequestMapping("/p_count_check/update_all")
    @ResponseBody
    public QueryStatus updateAll(PCountCheck pCountCheck) {
        return pCountCheckService.updateAll(pCountCheck);
    }

    //修改note
    @RequestMapping("/p_count_check/update_note")
    @ResponseBody
    public QueryStatus update_note(String pCountCheckId, String note) {
        return pCountCheckService.updateNote(pCountCheckId, note);
    }

    //删除
    @RequestMapping("/pCountCheck/delete_judge")
    @ResponseBody
    public String deleteJudgee() {
        return "";
    }

    //删除
    @RequestMapping("/p_count_check/delete_batch")
    @ResponseBody
    public QueryStatus deleteBatch(String[] ids) {
        return pCountCheckService.deleteBatch(ids);
    }

    //根据id查询
    @RequestMapping("/p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public BaseResultVo<PCountCheck> searchById(String searchValue, Integer page, Integer rows) {

        int offset = (page - 1) * rows;
        List<PCountCheck> unqualifyList = pCountCheckService.searchById(searchValue, rows, offset);
        baseResultVo.setTotal(pCountCheckService.searchAllById(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }
}
