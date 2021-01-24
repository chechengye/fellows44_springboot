package com.weichuang.fellows44_springboot;

import com.weichuang.fellows44_springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
