package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CZY-Y7000P
 */
@Controller
public class ExampleController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
