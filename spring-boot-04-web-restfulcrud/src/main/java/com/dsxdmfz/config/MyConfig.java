package com.dsxdmfz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurerAdapter 可以来扩展springMVC的功能
//但是，springboot2.0使用的spring5，Springboot2.0中WebMvcConfigurerAdapter过时，所以实现 WebMvcConfigurer接口来代替
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /dsxdmfz 请求来到 success
        registry.addViewController("/dsxdmfz").setViewName("success");
    }
}
