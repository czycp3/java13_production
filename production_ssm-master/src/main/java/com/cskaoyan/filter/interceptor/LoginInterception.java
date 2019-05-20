package com.cskaoyan.filter.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 15:18
 */
public class LoginInterception implements HandlerInterceptor {
    /*
     * 1.写一个拦截器
     * 2.在struts.xml配置一个拦截器
     * 3.配置一个拦截组，把登陆拦截器和struts配置拦截器添加进拦截组
     *
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        if (session.getAttribute("activeUser") != null || url.indexOf("/ajaxLogin")!= -1 || url.equals("/")){
            return true;
        } else {
            request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }



}
