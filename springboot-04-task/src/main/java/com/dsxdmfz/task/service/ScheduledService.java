package com.dsxdmfz.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Date: 2019/5/30
 * @Auther: lez
 */
@Service
public class ScheduledService {

    /**
     * 定时任务，属性cron 值的形式：0 * * * * 1-7  代表秒，分，时，日，月，星期，空格隔开，星期1-6代表周一到周六，0和7代表周日
     * 0,1,2,3,4 * * * * 1-5  周一到周五的0秒1秒2秒3秒4秒执行
     * 0-4 * * * * 1-5  周一到周五的0到4秒执行
     * 0/4 * * * * 1-5 周一到周五每隔4秒执行
     */
    @Scheduled(cron = "0,1,2,3,4 * * * * 1-5")
    public void hello(){
        System.out.println("hello...");
    }
}
