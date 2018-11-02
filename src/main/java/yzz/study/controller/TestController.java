package yzz.study.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import yzz.study.annoation.Redis;
import yzz.study.util.JedisClient;

@RestController
public class TestController {
	
	@Autowired
	private JedisClient jedisClient;
	
	@GetMapping("test")
	@Redis(type = Redis.Type.SELECT,expire=6,unit=TimeUnit.SECONDS)
	public void test(){
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		
		String s = jedisClient.set("zzy", list,TimeUnit.SECONDS,60);
		List<String> result = jedisClient.get("zzy");
		
		System.out.println("s:"+s+" ss:"+result.size());
	}
	
}
