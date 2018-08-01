package com.dsxdmfz.controller;

import com.dsxdmfz.dao.DepartmentDao;
import com.dsxdmfz.dao.EmployeeDao;
import com.dsxdmfz.entities.Department;
import com.dsxdmfz.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认就会拼串
        //classpath:/temlates/xxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("dpts",departments);
        return "emp/add";
    }

    //员工添加
    //springMvc自动请求参数和入参对象的属性进行--绑定；要求请求的参数名字和JavaBean入参对象里面的属性一样
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("保存成功!"+employee);
        //保存员工
        employeeDao.save(employee);
        //来到员工列表页面
        //redirect：表示重定向到一个地址  /代表当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/emps";
    }

}
