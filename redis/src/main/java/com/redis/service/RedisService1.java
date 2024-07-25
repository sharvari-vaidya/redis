package com.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.redis.entity.Product;

@Service
public class RedisService1 implements RedisServiceInter{

	@Autowired
	@Qualifier("Bean")
	RedisTemplate rt;
	
	private final Gson gson = new Gson();

	public String saveProduct(Product product) {
		System.out.println(product.toString());
		String json = gson.toJson(product);
		rt.opsForHash().put("Bean", product.getName(), json);
		return "Success";

	}

}
