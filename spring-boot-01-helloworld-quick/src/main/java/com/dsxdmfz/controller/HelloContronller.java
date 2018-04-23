package com.dsxdmfz.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContronller {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world quick";
    }
}
