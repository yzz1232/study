package yzz.study.util;


import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * jedis 工具类
    * @ClassName: JedisClient
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author Administrator
    * @date 2018年11月1日
    *
 */
public class JedisClient {
	
	private JedisPool jedisPool;
	
	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public Jedis getResource(){
		return jedisPool.getResource();
	}
	
	public String set(String key,String value,TimeUnit timeUnit,long expireTime){
		
		String unit = "";
		
		if(timeUnit == TimeUnit.SECONDS){
			unit = RedisEnum.EX.name();
		}else if(timeUnit == TimeUnit.MILLISECONDS){
			unit = RedisEnum.PX.name();
		}else{
			throw new RuntimeException("");
		}
		return getResource().set(key, value, RedisEnum.NX.getCode(), unit, expireTime);
	}
	
	public String get(String key){
		return getResource().get(key);
	}
	
	
	 static enum RedisEnum{
			
		  PX("PX","毫秒"),
		  EX("EX","秒"),
		  NX("NX","不存在set"),
		  XX("XX","存在set");
			
		  private String code;
		  
		  private String description;
		  
		  private RedisEnum(String code,String description){
			  this.code = code;
			  this.description = description;
		  }
		
		  
		  
		    public String getCode() {
			  return code;
		    }

			public void setCode(String code) {
				this.code = code;
			}



			public String getDescription() {
				return description;
			}



			public void setDescription(String description) {
				this.description = description;
			}

		}
}
