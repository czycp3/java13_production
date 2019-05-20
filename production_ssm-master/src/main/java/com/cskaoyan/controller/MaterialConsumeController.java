package com.cskaoyan.controller;

import com.cskaoyan.bean.BaseResultVo;
import com.cskaoyan.bean.Work;
import com.cskaoyan.service.MaterialConsumeService;
import com.cskaoyan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MaterialConsumeController {
    @Autowired
    private MaterialConsumeService materialConsumeService;

    @Autowired
    WorkService workService;

    BaseResultVo baseResultVo = new BaseResultVo();

    @RequestMapping("/materialConsume/find")
    public String materialConsumeFind(){
        return "materialConsume_list";
    }

    @RequestMapping("/materialConsume/list")
    public String materialConsumeList(){
        return null;
    }
}
