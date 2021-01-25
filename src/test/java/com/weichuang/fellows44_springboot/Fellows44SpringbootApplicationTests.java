package com.weichuang.fellows44_springboot;

import com.weichuang.fellows44_springboot.config.MyRedisTemplate;
import com.weichuang.fellows44_springboot.pojo.Employee;
import com.weichuang.fellows44_springboot.pojo.Person;
import com.weichuang.fellows44_springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;

@SpringBootTest
class Fellows44SpringbootApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	Person person;
	@Test
	void contextLoads() {
		System.out.println("person = " + person);
	}

	//日志级别：跟踪日志<调试日志<打印日志<警告日志<错误日志
	@Test
	void loggerTest(){
		System.out.println("测试日志输出");
		logger.trace("这是跟踪日志");
		logger.debug("这是调试日志");
		logger.info("这是打印日志");
		logger.warn("这是警告日志");
		logger.error("这是一个错误日志");
	}

	@Autowired
	DataSource dataSource;

	@Test
	void testDataSource(){
		System.out.println("dataSource = " + dataSource.getClass());
	}


	@Autowired
	StringRedisTemplate stringRedisTemplate;

	/**
	 * 以下操作仅限k,v都是字符串类型
	 * stringRedisTemplate.opsForValue() : 【String类型的操作】
	 * stringRedisTemplate.opsForList() ： 【List类型】
	 * stringRedisTemplate.opsForHash() ：【Hash散列】
	 * stringRedisTemplate.opsForSet() : 【Set类型】
	 * stringRedisTemplate.opsForZSet() : 【ZSet类型】
	 */
	@Test
	void testRedisFn(){
		//stringRedisTemplate.opsForValue().append("msgcode","zhangsan");
		//System.out.println(stringRedisTemplate.opsForValue().get("msg"));
		//stringRedisTemplate.opsForList().leftPush("listcode","23");
		stringRedisTemplate.opsForSet().add("setcode","123","234","456");
	}

	@Autowired
	RedisTemplate redisTemplate;
	@Autowired
	EmployeeService es;

	@Autowired
	RedisTemplate empRedisTemplate;
	@Test
	void testObjectRedisFn(){
		Employee employee = es.getEmployeeById(3);
		/**
		 * 默认的序列化机制是使用JdkSerializationRedisSerializer
		 * 我们习惯将对象类型的缓存转换为Json方便查看
		 * 1、自定义模板对象
		 * 2、从容器中获取对象的模板对象
		 */
		empRedisTemplate.opsForValue().set("emp-03",employee);
	}
}
