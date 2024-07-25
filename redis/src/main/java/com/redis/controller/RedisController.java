package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.entity.Product;
import com.redis.service.RedisServiceInter;

@RestController
public class RedisController {

	@Autowired
	RedisServiceInter rs;
	
	@PostMapping("/setData")
	public String setDataToRedis(@RequestBody Product product) {
		
		return rs.saveProduct(product);
	}
	
	
	
}
