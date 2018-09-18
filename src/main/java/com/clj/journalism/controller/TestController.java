package com.clj.journalism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Scheduled(cron = "0/60 * * * * *")
//    public void timer(){
//        System.out.println("定时器执行");
//        //清空
//        while (redisTemplate.opsForList().size("category1") > 0){
//            redisTemplate.opsForList().leftPop("category1");
//        }
//    }
}
