package com.buy.comtroller;

import com.buy.entity.Resource;
import com.buy.entity.User;
import com.buy.utils.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@RestController
@RequestMapping("/wx/")
public class BuyController {
    @Autowired
    private Resource resource;

    @RequestMapping("hello")
    public String hello(){
        return "Hello Spring boot!";
    }

    @RequestMapping("say")
    public String say(){
        return "my name is WangXin!,I super handsome~";
    }

    @RequestMapping("fyt")
    public String fyt(){
        return "<h1><span style='color:green'>王鑫</span> like <span style='color:red'>FengYunTing</span>(づ￣ 3￣)づ</h1>";
    }

    @RequestMapping("testJson")
    public String testJson(){
        User user = new User();
        user.setId(1);
        user.setName("王鑫");
        user.setAge(20);
        Date date = new Date();
        date.setYear(97);
        date.setMonth(12);
        date.setDate(8);

        return JsonUtils.objectToJson(user);
    }

    @RequestMapping("getResource")
    public String getResource() throws UnsupportedEncodingException {
        Resource r = new Resource();
        BeanUtils.copyProperties(resource,r);
        return JsonUtils.objectToJson(r);
    }

}
