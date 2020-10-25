package com.java.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * Redis 配置文件
 *
 * @Configuration 注解
 * 把该类作为spring的xml配置文件中的<beans>
 * 配置spring容器
 */
@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        //key 转String
        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);

        //value 转json
        MyStringRedisSerializer myStringRedisSerializer=new MyStringRedisSerializer();
        template.setValueSerializer(myStringRedisSerializer);
        template.setHashValueSerializer(myStringRedisSerializer);
        return template;
    }

}

