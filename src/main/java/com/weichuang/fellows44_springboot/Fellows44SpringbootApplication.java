package com.weichuang.fellows44_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @SpringBootApplication : 注解标识一个类为SpringBoot项目的启动类
 * 			此注解中一组组合注解，来完成相应的配置
 * 			@SpringBootConfiguration ： 配置类@Configuration 是Spring内部的注解，标识一个类是配置类
 * 			@EnableAutoConfiguration ：开启自动配置；不需要手动进行配置了。
 * 				@AutoConfigurationPackage ： 相当于Context包扫描。会扫描主配置类所在包目录下的所有目录和文件
 * 				@Import({AutoConfigurationImportSelector.class}):会帮我们导入一堆自动配置的类
 * 						会主动去auto配置包下面的META-INF/spring.factories 找寻自动配置类
 *							xxxAutoConfiguration
 *  使用缓存：
 *  1、开启缓存 @EnableCaching
 *
 *
 *  Redis集成：
 *  Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 *
 *  面试问到redis必问
 *  数据结构是：键值对 key,value
 *  它支持五种类型的数据结构，如 String字符串（strings）， Hash散列（hashes）， List列表（lists）， Set集合（sets）， ZSet有序集合（sorted sets）
 *
 */
@SpringBootApplication
@MapperScan("com.weichuang.fellows44_springboot.dao")
@EnableCaching
public class Fellows44SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fellows44SpringbootApplication.class, args);
	}

}
