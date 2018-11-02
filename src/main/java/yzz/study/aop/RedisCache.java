package yzz.study.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import yzz.study.annoation.Redis;
import yzz.study.util.JedisClient;


@Aspect
@Configuration
public class RedisCache {
	
	@Autowired
	private JedisClient jedisClient;
	
	@Pointcut(value = "@annotation(yzz.study.annoation.Redis)")
    public void serviceAspect() {
    }

	
	@Before(value = "serviceAspect() && @annotation(redis)")
	public void doBefore(Redis redis){
		long expire = redis.expire();
		Redis.Type type = redis.type();
		TimeUnit unit = redis.unit();
//		Object[] args = point.getArgs();
//		Signature signature = point.getSignature();
//		Object object = point.getTarget();
		System.out.println("1");
	}
  

	
}
