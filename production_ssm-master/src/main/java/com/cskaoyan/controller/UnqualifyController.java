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
 * @date 2019-05-17 23:46
 */

@Controller
public class UnqualifyController {
    @Autowired
    UnqualifyService unqualifyService;


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

        BaseResultVo baseResultVo = new BaseResultVo();

        int offset = (page - 1) * rows;
        List<Unqualify> unqualifyList = unqualifyService.findList(rows,offset);
        baseResultVo .setTotal(unqualifyService.findAllList().size());
        baseResultVo .setRows(unqualifyList);

        return baseResultVo ;
    }

    /**
     * 打开add界面
     * @return
     */
    @RequestMapping("/unqualify/add_judge")
    public String add_judge(){
        return "unqualify_add";
    }

    @RequestMapping("unqualify/add")
    public String add(){
        return "unqualify_add";
    }

    @RequestMapping("unqualify/insert")
    @ResponseBody
    public QueryStatus insert(Unqualify unqualify){
        return unqualifyService.insert(unqualify);
    }



}
