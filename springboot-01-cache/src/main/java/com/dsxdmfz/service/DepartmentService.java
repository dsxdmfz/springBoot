package com.dsxdmfz.service;

import com.dsxdmfz.bean.Department;
import com.dsxdmfz.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Date: 2019/5/15
 * @Auther: lez
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    CacheManager deptCacheManager;

//    @Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
//    public Department getDeptById(Integer id){
//        System.out.println("查询部门"+id);
//        Department department = departmentMapper.getDeptId(id);
//        return department;
//    }


    //使用缓存管理器得到缓存，进行API调用
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptId(id);
        //获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");

        dept.put(id,department);

        return department;
    }

}
