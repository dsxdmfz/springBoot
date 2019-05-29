package com.dsxdmfz.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Date: 2019/5/29
 * @Auther: lez
 */
@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中。。。");
    }
}
