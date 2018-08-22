package com.buy.comtroller;

import com.buy.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by win7 on 2018/7/27.
 */
@Controller
@RequestMapping("/ftl/")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("resource",resource);
        mv.setViewName("freemarker/index");
        return mv;
    }
}
