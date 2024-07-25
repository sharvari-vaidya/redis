package com.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory config() {
		RedisStandaloneConfiguration con = new RedisStandaloneConfiguration();
		con.setPort(6379);
		con.setHostName("localhost");
		return new JedisConnectionFactory(con);
	}

	@Bean("Bean")
	RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(config());
//		template.setKeySerializer(new StringRedisSerializer());
//		template.setHashKeySerializer(new StringRedisSerializer());
//		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
//		template.setValueSerializer(new StringRedisSerializer());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		return template;
	}

//	public RedisTemplate<String, Object> getRedisTemplate(){
//		RedisTemplate<String, Object> rt= new RedisTemplate<>();
//		rt.setConnectionFactory(config());
//		rt.setKeySerializer(new StringRedisSerializer());
//		rt.setHashKeySerializer(new StringRedisSerializer());
//		rt.setHashKeySerializer(new JdkSerializationRedisSerializer());
//		rt.setValueSerializer(new GenericToStringSerializer<>(Object.class));
//		rt.setEnableTransactionSupport(true);
//		rt.afterPropertiesSet();
//		return rt;
//	}
}
