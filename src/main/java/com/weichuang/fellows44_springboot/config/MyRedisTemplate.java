package com.weichuang.fellows44_springboot.config;

import com.weichuang.fellows44_springboot.pojo.Employee;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class MyRedisTemplate {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Employee.class));
        return template;
    }
}
