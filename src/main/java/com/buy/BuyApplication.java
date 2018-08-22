package com.buy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//扫描mybatis mapper包路径
@MapperScan(basePackages = "com.buy.mapper")
//扫描所有需要的包，包含一些自用的工具包 所在的路径
@ComponentScan(basePackages = {"com.buy"})
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class BuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyApplication.class, args);
	}
}
