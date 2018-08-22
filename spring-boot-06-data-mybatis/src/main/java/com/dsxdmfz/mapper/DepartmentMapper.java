package com.dsxdmfz.mapper;

import com.dsxdmfz.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDepartment(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName}) ")
    int insertDepartment(Department department);

    @Delete("delete from department where id = #{id}")
    int deleteDepartment(Integer id);

    @Update("update department set department_name= #{departmentName} where id = #{id}")
    int updateDepartment(Department department);

}
