package com.dsxdmfz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个springBoot应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //spring 应用启动起来
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
