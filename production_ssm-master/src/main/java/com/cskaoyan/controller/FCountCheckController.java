package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 01:41
 * 成品计数质检 Controller
 */
@Controller
public class FCountCheckController {

    @RequestMapping("f_count_check/find")
    public String find(){
        return "f_count_check_list";
    }
}
