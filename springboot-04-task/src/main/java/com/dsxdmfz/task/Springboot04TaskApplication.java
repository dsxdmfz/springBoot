package com.dsxdmfz.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Springboot04TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04TaskApplication.class, args);
    }

}
