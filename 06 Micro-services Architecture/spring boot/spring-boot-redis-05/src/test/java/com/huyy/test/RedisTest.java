package com.huyy.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.pojo.Users;

/**
 * Spring Data Redis测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RedisTest {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 基于JSON格式存Users对象
	 */

	@Test
	public void testSetUsersUseJSON() {
		Users users = new Users();
		users.setAge(20);
		users.setName("王布");
		users.setId(1);
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		this.redisTemplate.opsForValue().set("users_json", users);
	}

	/**
	 * 基于JSON格式取Users对象
	 */
	@Test
	public void testGetUseJSON() {
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
		Users users = (Users) this.redisTemplate.opsForValue().get("users_json");
		System.out.println(users);
	}

	/*
	 * 测试删除
	 */
	@Test
	public void testDelete() {
		this.redisTemplate.opsForValue().set("deletekey", "123456");
		this.redisTemplate.delete("deletekey");
		boolean exists = redisTemplate.hasKey("deletekey");
		if (exists) {
			System.out.println("exists is true");
		} else {
			System.out.println("exists is false");
		}
	}

	/* 测试hash */
	@Test
	public void testHash() {
		this.redisTemplate.opsForHash().put("hash01", "hash01key", "hash01value");
		// hash value :hash01value
		System.out.println("hash value :" + (String) this.redisTemplate.opsForHash().get("hash01", "hash01key"));
		// hash:[hash01value]
		System.out.println("hash:" + this.redisTemplate.opsForHash().values("hash01"));
	}

	/* 测试List */
	@Test
	public void testList() { // moi you xv
		this.redisTemplate.opsForList().leftPush("list", "xv");// 从左插入
		this.redisTemplate.opsForList().leftPush("list", "you");
		this.redisTemplate.opsForList().leftPush("list", "moi");
		// list value :moi
		System.out.println("list value :" + (String) this.redisTemplate.opsForList().leftPop("list").toString());
	}

	/* 测试set */
	@Test
	public void testSet() {
		String key = "set";
		this.redisTemplate.opsForSet().add(key, "it");
		this.redisTemplate.opsForSet().add(key, "you");
		this.redisTemplate.opsForSet().add(key, "you");
		this.redisTemplate.opsForSet().add(key, "know");
		Set<String> values = (Set) this.redisTemplate.opsForSet().members(key);
		/*
		 * set value :know set value :it set value :you
		 */
		for (String v : values) {
			System.out.println("set value :" + v);
		}
	}

	/* 测试zset */
	@Test
	public void testZset() {
		String key = "zset";
		redisTemplate.delete(key);
		this.redisTemplate.opsForZSet().add(key, "it", 1);
		this.redisTemplate.opsForZSet().add(key, "you", 6);
		this.redisTemplate.opsForZSet().add(key, "know", 4);
		this.redisTemplate.opsForZSet().add(key, "neo", 3);
		Set<String> zsets = (Set) this.redisTemplate.opsForZSet().range(key, 0, 3);
//		zset value :it
//		zset value :neo
//		zset value :know
//		zset value :you
		for (String v : zsets) {
			System.out.println("zset value :" + v);
		}
	}
}
