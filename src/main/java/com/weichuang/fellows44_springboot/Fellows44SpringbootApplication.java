package com.weichuang.fellows44_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication : 注解标识一个类为SpringBoot项目的启动类
 * 			此注解中一组组合注解，来完成相应的配置
 * 			@SpringBootConfiguration ： 配置类@Configuration 是Spring内部的注解，标识一个类是配置类
 * 			@EnableAutoConfiguration ：开启自动配置；不需要手动进行配置了。
 * 				@AutoConfigurationPackage ： 相当于Context包扫描。会扫描主配置类所在包目录下的所有目录和文件
 * 				@Import({AutoConfigurationImportSelector.class}):会帮我们导入一堆自动配置的类
 * 						会主动去auto配置包下面的META-INF/spring.factories 找寻自动配置类
 *							xxxAutoConfiguration
 *
 *
 */
@SpringBootApplication
public class Fellows44SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fellows44SpringbootApplication.class, args);
	}

}
