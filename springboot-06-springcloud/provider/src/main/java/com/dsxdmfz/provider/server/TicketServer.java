package com.dsxdmfz.provider.server;

import org.springframework.stereotype.Service;

/**
 * @Date: 2019/6/18
 * @Auther: lez
 */
@Service
public class TicketServer {

    public String getTicket(){
        System.out.println("8001");
        return "《厉害了，我的国》";
    }
}
