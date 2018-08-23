package com.dsxdmfz.controller;

import com.dsxdmfz.entity.User;
import com.dsxdmfz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        /**
         * springBoot1.5的时候使用spring data jpa在JpaRepository下提供两个方法：
         * findOne(id) 返回一个类型实体
         * getOne(id) 返回一个实体引用
         * 而在2.0版本没有了findOne()方法，取而代之的是CrudRepository中的findById()，返回一个Optional，一个泛型容器，可以通过get（）获取容器里的元素。
         */
        User user = userRepository.findById(id).get();
        return user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
