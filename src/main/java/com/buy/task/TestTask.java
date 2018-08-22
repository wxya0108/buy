package com.buy.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by win7 on 2018/8/1.
 */

/**
 * cron表达式生成网址：http://cron.qqe2.com/
 * SpringBoot在cron表达式中不支持年
 */

@Component
public class TestTask {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //每过3秒执行任务
    @Scheduled(fixedRate = 50000)
    public void test(){
        System.out.println("自动任务类："+format.format(new Date()));
    }
}
