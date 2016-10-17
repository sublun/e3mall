package cn.e3mall.jedis;

import java.util.Set;

public interface JedisClient {

	String set(String key, String value);
	String get(String key);
	Boolean exists(String key);
	Long expire(String key, int seconds);
	Long ttl(String key);
	Long incr(String key);
	Long hset(String key, String field, String value);
	String hget(String key, String field);
	Boolean hexists(String key, String field);
	Long hdel(String key, String... field);
	Long zadd(String key, double score, String member);
	Set<String> zrange(String key, long start, long end);
	Set<String> zrevrange(String key, long start, long end);
	Long zrem(String key, String... member);
}
