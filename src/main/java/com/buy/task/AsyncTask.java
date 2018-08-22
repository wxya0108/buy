package com.buy.task;

import com.buy.entity.User;
import com.buy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by win7 on 2018/8/3.
 * 异步任务
 */

@Component
public class AsyncTask {
    @Autowired
    private IUserService userService;

    @Async
    public void taskFindUser(int userId) throws InterruptedException {
        Thread.sleep(10000);

        System.out.println("~~~进入异步任务，开始查询");

        User user = userService.getUser(userId);
        if(user!=null){
            System.out.println("异步任务处理完成，用户id："+userId);
        }
    }
}
