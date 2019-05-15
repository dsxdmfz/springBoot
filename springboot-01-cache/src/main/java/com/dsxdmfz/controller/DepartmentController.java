package com.dsxdmfz.controller;

import com.dsxdmfz.bean.Department;
import com.dsxdmfz.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019/5/15
 * @Auther: lez
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        Department department = departmentService.getDeptById(id);
        return department;
    }
}
