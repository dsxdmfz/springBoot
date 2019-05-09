package com.dsxdmfz.service;

import com.dsxdmfz.bean.Employee;
import com.dsxdmfz.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法
     *
     * CacheManage管理多个Cache组件的，对缓存的正真CRUD操作再cache组件中，每一个缓存组件有自己唯一一个名字；
     * 几个属性：
     *  cacheNames/value：指定缓存组件的名字
     *  key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值 key-value:1-方法的返回值
     *          编写SpEl:#id;参数id的值   #a0 #p0 #toot.args[0]
     *  keyGenerator: key的生成器；可以自己指定key的生成器组件id
     *      key/keyGenerator    二选一使用
     *  cacheManage：指定缓存管理器；或者cacheResolver指定获取解析器
     *  condition：指定符合条件的情况下才缓存；
     *      condition="#rid>0"
     *      condition = "#a0>1" 第一个参数值>1的时候才进行缓存
     *  unless：否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *      unless="#result==null"
     *      unless = "#a0==2" 如果第一个参数值是2，结果不缓存
     *  sync:是否使用异步模式，异步情况下不支持unless
     *
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "emp", key = "#root.methodName+'['+#id+']'")
//    @Cacheable(cacheNames = "emp", keyGenerator = "myKeyGenerator",condition = "#a0>1",unless = "#a0==2")
    @Cacheable(cacheNames = "emp")
    public Employee getEmployee(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.getEmployee(id);
        return employee;
    }

    /**
     * @CachePut:既调用方法，又更新缓存数据；同步更新缓存
     * 修改了数据库的某个数据，同时更新缓存
     * 运行时机：
     *     1、先调用目标方法
     *     2、将目标方法的结果缓存起来
     *
     *  更新的时候同步缓存，必须指定同一个缓存的key
     *  key = "#employee.id"  和  "#result.id"  都是Employee的id，既查询时使用的key
     *
     *
     * @param employee
     * @return
     */
    @CachePut(value = "emp",key = "#result.id")
    public Employee updataEmployee(Employee employee) {
        System.out.println("updata:"+employee);
       employeeMapper.updateEmployee(employee);
        return employee;
    }

}
