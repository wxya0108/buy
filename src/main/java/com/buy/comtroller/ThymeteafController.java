package com.buy.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by win7 on 2018/7/30.
 */

@Controller
@RequestMapping("/thy/")
public class ThymeteafController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","王鑫");
        mv.setViewName("thymeleaf/index");
        return mv;
    }

    @RequestMapping("errors")
    public String errors(){
        String a = "wx";
        int i = 1/0;
        return "thymeleaf/index";
    }
}
