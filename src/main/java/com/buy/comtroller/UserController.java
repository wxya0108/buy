package com.buy.comtroller;

import com.buy.entity.IMoocJSONResult;
import com.buy.entity.User;
import com.buy.service.IUserService;
import com.buy.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by win7 on 2018/7/30.
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("addUser")
    public IMoocJSONResult addUser(User user) throws UnsupportedEncodingException {
        user.setName(new String(user.getName().getBytes("UTF-8")));

        IMoocJSONResult result = new IMoocJSONResult();
        int i = userService.addUser(user);
        if(i>0){
            result.setOk("新增成功");
        }else{
            result.setMsg("新增失败");
        }
        return result;
    }

    @RequestMapping("editUser")
    public IMoocJSONResult editUser(User user){
        IMoocJSONResult result = new IMoocJSONResult();
        int i = userService.editUser(user);
        if(i>0){
            result.setOk("修改成功");
        }else{
            result.setMsg("修改失败");
        }
        return result;
    }

    @RequestMapping("delUser")
    public IMoocJSONResult delUser(int id){
        IMoocJSONResult result = new IMoocJSONResult();
        int i = userService.delUser(id);
        if(i>0){
            result.setOk("删除成功");
        }else{
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("getUser")
    public IMoocJSONResult getUser(int id){
        IMoocJSONResult result = new IMoocJSONResult();
        User user = userService.getUser(id);
        if(user!=null){
            result.setOk("成功");
            result.setData(user);
        }else{
            result.setMsg("查询失败");
        }
        return result;
    }

    @RequestMapping("findUser")
    public IMoocJSONResult getUser(String name,int pageIndex) throws InterruptedException {
        IMoocJSONResult result = new IMoocJSONResult();
        List<User> list = userService.findUser(name,pageIndex);
        if(list!=null && list.size()!=0){
            result.setOk("成功");
            result.setData(list);

            for(int i=0;i<list.size();i++){
                User user = list.get(i);
                asyncTask.taskFindUser(user.getId());
            }
        }else{
            result.setMsg("暂无数据");
        }
        return result;
    }
}
