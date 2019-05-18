package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther 芮狼Dan
 * @date 2019-05-18 19:34
 * 成品计量质检的contriller
 */
@Controller
public class MeasureController {
    @RequestMapping("measure/find")
    public String find(){
        return "measurement_list";
    }

}
