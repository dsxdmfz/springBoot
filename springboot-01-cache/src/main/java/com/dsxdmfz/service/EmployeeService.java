package com.dsxdmfz.service;

import com.dsxdmfz.bean.Employee;
import com.dsxdmfz.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmployee(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.getEmployee(id);
        return employee;
    }

}
