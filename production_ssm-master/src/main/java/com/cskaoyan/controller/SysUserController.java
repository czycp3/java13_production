package com.cskaoyan.controller;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 15:55
 */
@Controller
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/")
    public String login(HttpSession session){
        if(session.getAttribute("activeUser") == null){
            return "login";
        } else {
            return "home";
        }

    }


    @RequestMapping("/ajaxLogin")
    @ResponseBody
    public Map<String,Object> ajaxLogin(String username, String password, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        SysUser sysUser = sysUserService.findByUsername(username);
        if (sysUser == null){
            map.put("msg","account_error");
        }else if (!password.equals(sysUser.getPassword())){
            map.put("msg","password_error");
        } else {
            session.setAttribute("activeUser",sysUser);
        }


        return map;
    }


    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("activeUser");

        return "login";
    }


}
