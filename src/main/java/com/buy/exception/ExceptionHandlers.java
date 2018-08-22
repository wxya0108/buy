package com.buy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by win7 on 2018/7/30.
 * 异常信息拦截返回工具
 */

@ControllerAdvice
public class ExceptionHandlers {
    public static final String ERROR_URL = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();

        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",e);
        mv.addObject("url",request.getRequestURI());
        mv.setViewName(ERROR_URL);
        return mv;
    }

}
