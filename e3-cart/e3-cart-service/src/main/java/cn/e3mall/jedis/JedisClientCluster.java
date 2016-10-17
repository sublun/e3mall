package cn.e3mall.jedis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;

public class JedisClientCluster implements JedisClient {
	
	@Autowired
	private JedisCluster jedisCluster;

	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public Boolean exists(String key) {
		return jedisCluster.exists(key);
	}

	@Override
	public Long expire(String key, int seconds) {
		return jedisCluster.expire(key, seconds);
	}

	@Override
	public Long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	@Override
	public Long incr(String key) {
		return jedisCluster.incr(key);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return jedisCluster.hset(key, field, value);
	}

	@Override
	public String hget(String key, String field) {
		return jedisCluster.hget(key, field);
	}

	@Override
	public Long hdel(String key, String... field) {
		return jedisCluster.hdel(key, field);
	}

	@Override
	public Boolean hexists(String key, String field) {
		return jedisCluster.hexists(key, field);
	}

	@Override
	public Long zadd(String key, double score, String member) {
		return jedisCluster.zadd(key, score, member);
	}

	@Override
	public Set<String> zrange(String key, long start, long end) {
		return jedisCluster.zrange(key, start, end);
	}

	@Override
	public Set<String> zrevrange(String key, long start, long end) {
		return jedisCluster.zrevrange(key, start, end);
	}

	@Override
	public Long zrem(String key, String... member) {
		return jedisCluster.zrem(key, member);
	}

}
