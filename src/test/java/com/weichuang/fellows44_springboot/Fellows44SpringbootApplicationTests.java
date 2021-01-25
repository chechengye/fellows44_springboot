package com.weichuang.fellows44_springboot;

import com.weichuang.fellows44_springboot.config.MyRedisTemplate;
import com.weichuang.fellows44_springboot.pojo.Book;
import com.weichuang.fellows44_springboot.pojo.Employee;
import com.weichuang.fellows44_springboot.pojo.Person;
import com.weichuang.fellows44_springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

	@Autowired
	RabbitTemplate rabbitTemplate;
	@Test
	void testRabbitFn(){
		Map<String , Object> map = new HashMap();
		map.put("msg","测试代码发送消息");
		map.put("data", Arrays.asList("hello" , 22 , true));
		//默认不是一种Json序列化的消息
		rabbitTemplate.convertAndSend("exchange.direct","weichuang",map);
	}

	/**
	 * 接收消息队列的信息
	 */
	@Test
	void receiveFn(){
		System.out.println("receiveFn : " + rabbitTemplate.receiveAndConvert("weichuang"));
	}

	@Test
	void testObjectRabbitFn(){
		Book book = new Book();
		book.setAuthor("三国演义");
		book.setName("罗贯中");
		rabbitTemplate.convertAndSend("exchange.topic","*.news",book);
	}

	//代码中怎么做到实时监听消息呢？
	//通过AmqpAdmin 来使用代码的方法创建交换机与队列、绑定路由键规则
	@Autowired
	AmqpAdmin amqpAdmin;
	@Test
	void testAmqpAdminFn(){
		//amqpAdmin.declareExchange(new DirectExchange("exchangecode.direct"));
		//amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE ,"exchangecode.direct","amqpadmin.queue" , null ));
	}
}
