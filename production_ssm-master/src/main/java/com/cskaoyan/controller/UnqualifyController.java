package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.QueryStatus;
import com.cskaoyan.bean.Unqualify;
import com.cskaoyan.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-18 19:37
 * 不合格品管理的contriller
 */
@Controller
public class UnqualifyController {
    @Autowired
    UnqualifyService unqualifyService;

    //新建提交的json对象
    BaseResultVo baseResultVo=new BaseResultVo();

    /**
     * 通过访问/unqualify/find，返回unqualify_list.jsp
     * @return
     */
    @RequestMapping("/unqualify/find")
    public String find() {
        return "unqualify_list";
    }

    /**
     * 通过传入page和rows来进行分页查询
     * @param page 当前第几页
     * @param rows 每页有多少行
     * @return
     */
    @RequestMapping("/unqualify/list")
    @ResponseBody
    public BaseResultVo<Unqualify> findUnqualifyList(Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<Unqualify> unqualifyList = unqualifyService.findList(rows,offset);
        baseResultVo.setTotal(unqualifyService.findAllList().size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }

    //增加
    @RequestMapping("/unqualify/add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    //增加
    @RequestMapping("unqualify/add")
    public String add(){
        return "unqualify_add";
    }

    //增加
    @RequestMapping("unqualify/insert")
    @ResponseBody
    public QueryStatus insert(Unqualify unqualify){
        return unqualifyService.insert(unqualify);
    }

    //修改全部信息
    @RequestMapping("/unqualify/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    //修改全部信息
    @RequestMapping("/unqualify/edit")
    public String edit(){
        return "unqualify_edit";
    }

    //修改全部信息
    @RequestMapping("/unqualify/update_all")
    @ResponseBody
    public QueryStatus update_all(Unqualify unqualify){
        return unqualifyService.update_all(unqualify);
    }

    //修改note
    @RequestMapping("unqualify/update_note")
    @ResponseBody
    public QueryStatus update_note(String unqualifyApplyId, String note){
        return unqualifyService.update_note(unqualifyApplyId,note);
    }


    //删除
    @RequestMapping("/unqualify/delete_judge")
    @ResponseBody
    public String delete_judgee(){
        return "";
    }

    //删除
    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public QueryStatus delete_batch(String[] ids){
        return unqualifyService.delete_batch(ids);
    }

    //根据id查询
    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")
    @ResponseBody
    public BaseResultVo<Unqualify> searchUnqualifyByUnqualifyId(String searchValue,Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<Unqualify> unqualifyList = unqualifyService.searchUnqualifyByUnqualifyId(searchValue,rows,offset);
        baseResultVo.setTotal(unqualifyService.searchAllUnqualifyByUnqualifyId(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }


    //根据产品名称查询
    @RequestMapping("unqualify/search_unqualify_by_productName")
    @ResponseBody
    public BaseResultVo<Unqualify> searchUnqualifyByProductName(String searchValue,Integer page, Integer rows){

        int offset = (page - 1) * rows;
        List<Unqualify> unqualifyList = unqualifyService.searchUnqualifyByPAgeByProductName(searchValue,rows,offset);
        baseResultVo.setTotal(unqualifyService.searchAllUnqualifyByProductName(searchValue).size());
        baseResultVo.setRows(unqualifyList);

        return baseResultVo;
    }
}
