package com.dsxdmfz.consumer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date: 2019/6/18
 * @Auther: lez
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/buy")
    public String buy(String name){
        String s = restTemplate.getForObject("http://PROVIDER/ticket", String.class);
        return name+"购买了"+s;
    }

}
