package com.cskaoyan.exception.exceptionhandle;

import com.cskaoyan.exception.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
//        if(e instanceof CustomException){
//            modelAndView.setViewName("error");
//            modelAndView.addObject("msg",e.getMessage());
//        }
        return modelAndView;
    }
}
