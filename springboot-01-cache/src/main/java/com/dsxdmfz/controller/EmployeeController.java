package com.dsxdmfz.controller;

import com.dsxdmfz.bean.Employee;
import com.dsxdmfz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee updata(Employee employee){
        Employee emp = employeeService.updataEmployee(employee);
        return emp;
    }

    @GetMapping("/delEmp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "succeed";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmployee(@PathVariable("lastName") String lastName){
        Employee employee = employeeService.getEmpByLastName(lastName);
        return employee;
    }

}
