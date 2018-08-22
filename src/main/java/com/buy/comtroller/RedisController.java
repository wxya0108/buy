package com.buy.comtroller;

import com.buy.entity.IMoocJSONResult;
import com.buy.entity.User;
import com.buy.service.IUserService;
import com.buy.utils.JsonUtils;
import com.buy.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by win7 on 2018/8/1.
 */

@RestController
@RequestMapping("/redis/")
public class RedisController {
    @Autowired
    private IUserService userService;
    @Autowired
    private RedisOperator redis;

    @RequestMapping("testSet")
    public void testSet(String key,String value){
        redis.set(key,value);
    }

    @RequestMapping("testGet")
    public String testGet(String key){
        String value = redis.get(key);
        return value;
    }

    @RequestMapping("testUser")
    public IMoocJSONResult testUser(int id){
        IMoocJSONResult result = new IMoocJSONResult();

        String jsonUser = redis.get("user:"+id);
        if(jsonUser==null){
            User user = userService.getUser(id);
            if(user!=null){
                redis.set("user:"+id,JsonUtils.objectToJson(user));
                result.setData(user);
                result.setOk("成功从数据库中拿到user:"+id);
            }else{
                result.setMsg("该用户不存在");
            }
            return result;
        }else{
            User user = JsonUtils.jsonToPojo(jsonUser,User.class);
            result.setData(user);
            result.setOk("成功从redis中拿到user:"+id);
            return result;
        }
    }

    @RequestMapping("testUserList")
    public IMoocJSONResult testUserList(int pageIndex){
        IMoocJSONResult result = new IMoocJSONResult();

        String jsonUser = redis.get("list:user");
        if(jsonUser==null){
            List<User> list = userService.findUser(null,pageIndex);
            if(list!=null){
                redis.set("list:user",JsonUtils.objectToJson(list));
                result.setData(list);
                result.setOk("成功从数据库中拿到userList");
            }else{
                result.setMsg("无");
            }
            return result;
        }else{
            List<User> list = JsonUtils.jsonToList(jsonUser,User.class);
            result.setData(list);
            result.setOk("成功从redis中拿到userList");
            return result;
        }
    }
}
