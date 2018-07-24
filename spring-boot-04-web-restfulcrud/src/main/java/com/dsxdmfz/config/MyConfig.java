package com.dsxdmfz.config;

import com.dsxdmfz.component.LoginHandelerInterceptor;
import com.dsxdmfz.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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

    //使用WebMvcConfigurerAdapter过时，用WebMvcConfigurer代替
    //所有的WebMvcConfigurer组件都会在一起起作用
    @Bean//将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源已经由springBoot配置好了
                registry.addInterceptor(new LoginHandelerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/","/index.html","/user/login");
            }
        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocalResolver();
    }

}
