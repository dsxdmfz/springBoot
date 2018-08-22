package com.dsxdmfz.mapper;

import com.dsxdmfz.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

//@Mapper或@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
