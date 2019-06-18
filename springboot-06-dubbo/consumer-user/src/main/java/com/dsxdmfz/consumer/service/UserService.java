package com.dsxdmfz.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dsxdmfz.provider.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @Date: 2019/6/5
 * @Auther: lez
 */
@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到了"+ticket);
    }

}
