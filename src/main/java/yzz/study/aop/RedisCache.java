package yzz.study.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import yzz.study.util.JedisClient;


@Aspect
@Configuration
public class RedisCache {
	
	@Autowired
	private JedisClient jedisClient;
	
	@Poincut("")
	public void redisAspect(){
		
	}
	
	@Before("")
	public void doBefore(){
		
	}
  

	
}
