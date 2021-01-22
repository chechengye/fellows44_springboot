package com.weichuang.fellows44_springboot;

import com.weichuang.fellows44_springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Fellows44SpringbootApplicationTests {

	@Autowired
	Person person;
	@Test
	void contextLoads() {
		System.out.println("person = " + person);
	}

}
