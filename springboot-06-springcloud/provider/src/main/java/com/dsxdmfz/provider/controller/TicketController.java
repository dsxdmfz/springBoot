package com.dsxdmfz.provider.controller;

import com.dsxdmfz.provider.server.TicketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019/6/18
 * @Auther: lez
 */
@RestController
public class TicketController {

    @Autowired
    TicketServer ticketServer;

    @GetMapping("/ticket")
    public String getTicket(){
        return ticketServer.getTicket();
    }

}
