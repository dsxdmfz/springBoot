package com.dsxdmfz;

import com.dsxdmfz.bean.Employee;
import com.dsxdmfz.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	RedisTemplate EmpRedisTemplate;


	/**
	 * Redis常见的五大数据类型
	 * string（字符串）、list（列表）、set（集合）、hash（散列）、zset（有序集合）
	 * stringRedisTemplate.opsForValue()[string（字符串）]
	 * stringRedisTemplate.opsForList()[list（列表）]
	 * stringRedisTemplate.opsForSet()[set（集合）]
	 * stringRedisTemplate.opsForHash()[hash（散列）]
	 * stringRedisTemplate.opsForZSet()[zset（有序集合）]
	 */
	@Test
	public void test01(){
//		stringRedisTemplate.opsForValue().append("msg1","hello");
//		String msg1 = stringRedisTemplate.opsForValue().get("msg1");
//		System.out.println(msg1);

		stringRedisTemplate.opsForList().leftPush("mylist1","q");
		stringRedisTemplate.opsForList().leftPush("mylist1","w");
		stringRedisTemplate.opsForList().leftPush("mylist1","e");
	}

	//测试保存对象
	@Test
	public  void rest02(){
		Employee employee = employeeMapper.getEmployee(1);
		//默认如果保存对象，使用jdk序列化机制，序列化的数据保存到Redis中

//		redisTemplate.opsForValue().set("emp-01",employee);

		//1、将数据以json的方式保存
		//（1）、自己将对象转为jsom
		//（2）、redisTemplate默认的序列化规则,改变默认的序列化规则

		EmpRedisTemplate.opsForValue().set("emp-01",employee);
	}

	@Test
	public void contextLoads() {
		Employee employee = employeeMapper.getEmployee(1);
		System.out.println(employee);
	}

}
