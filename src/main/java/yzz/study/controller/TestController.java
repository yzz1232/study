package yzz.study.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import yzz.study.util.JedisClient;

@RestController
public class TestController {
	
	@Autowired
	private JedisClient jedisClient;
	
	@GetMapping("test")
	public void test(){
		String s = jedisClient.set("zzy", "1994",TimeUnit.SECONDS,60);
		String ss = jedisClient.get("zzy");
		System.out.println("s:"+s+" ss:"+ss);
	}
	
}
