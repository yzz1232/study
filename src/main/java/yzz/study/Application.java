package yzz.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import yzz.study.util.JedisClient;


@SpringBootApplication
public class Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
	
	
	
	@Configuration
	@ConfigurationProperties(prefix="spring.redis")
	public static class RedisConfig {
		
		private String host;
		
		private int port;
		
		private int timeout;
		
		private String password;
		
		private int database;
		
		@Bean
		public JedisPool jedisPool() {
			JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), host, port, timeout, password, database);
			return jedisPool;
		}
		
		@Bean
		public JedisClient jedisClient(JedisPool jedisPool) {
			JedisClient jedisClient = new JedisClient();
			jedisClient.setJedisPool(jedisPool);
			return jedisClient;
		}
		

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getDatabase() {
			return database;
		}

		public void setDatabase(int database) {
			this.database = database;
		}

		public int getTimeout() {
			return timeout;
		}

		public void setTimeout(int timeout) {
			this.timeout = timeout;
		}
		
		
	}
	
	
}
	
   
