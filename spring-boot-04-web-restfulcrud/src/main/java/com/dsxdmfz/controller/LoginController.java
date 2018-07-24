package com.dsxdmfz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @PutMapping
//    @GetMapping


//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)

    @PostMapping(value = "/user/login")
    public String login(@RequestParam(name = "username") String username,
                        @RequestParam(name = "password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功，防止表单重复提交，重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            //登录失败，返回错误信息
            map.put("msg","账户或密码错误");
            return "login";
        }
    }
}
