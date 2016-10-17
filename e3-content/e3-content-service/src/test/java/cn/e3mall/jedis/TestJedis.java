package cn.e3mall.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.e3mall.jedis.JedisClient;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class TestJedis {

	@Test
	public void testJedis() throws Exception {
		Jedis jedis = new Jedis("192.168.25.153", 6379);
		jedis.set("mytest", "1000");
		String string = jedis.get("mytest");
		System.out.println(string);
		jedis.close();
	}
	
	@Test
	public void testJedisPool() throws Exception {
		JedisPool jedisPool = new JedisPool("192.168.25.153", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.set("mytest2", "abcd");
		String string = jedis.get("mytest2");
		System.out.println(string);
		jedis.close();
		jedisPool.close();
	}
	
	@Test
	public void testJedisCluster() throws Exception {
		//创建一个节点列表
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.153", 7001));
		nodes.add(new HostAndPort("192.168.25.153", 7002));
		nodes.add(new HostAndPort("192.168.25.153", 7003));
		nodes.add(new HostAndPort("192.168.25.153", 7004));
		nodes.add(new HostAndPort("192.168.25.153", 7005));
		nodes.add(new HostAndPort("192.168.25.153", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("helloworld", "my jediscluster");
		String string = jedisCluster.get("helloworld");
		System.out.println(string);
		jedisCluster.close();
	}
	
	@Test
	public void testSpringJedis() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("hello1234", "1000");
		String string = jedisClient.get("hello1234");
		System.out.println(string);
		
	}
}
