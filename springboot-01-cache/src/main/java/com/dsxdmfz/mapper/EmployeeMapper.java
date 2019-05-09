package com.dsxdmfz.mapper;

import com.dsxdmfz.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id=#{id}")
    public Employee getEmployee(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#lastName,#email,#gender,#dId)")
    void saveEmployee(Employee employee);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    void updateEmployee(Employee employee);

    @Delete("DELETE FROM employee WHERE id=#{id}")
    void deleteEmployee(Integer id);

}
