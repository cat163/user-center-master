package com.whq.usercenter.service;
import java.util.Date;

import com.whq.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @author: whq
 * @description:
 * @time: 2023/2/6 16:30
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void test(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("string", "dog");
        valueOperations.set("int", 1);
        valueOperations.set("double", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("whq");
        valueOperations.set("user", user);

        // 查
        Object whq = valueOperations.get("string");
        Assertions.assertEquals("dog", whq);
        whq = valueOperations.get("int");
        Assertions.assertEquals(1,whq);
        whq = valueOperations.get("double");
        Assertions.assertEquals(2.0,whq);
        System.out.println(valueOperations.get("user"));

        // 改
        redisTemplate.delete("string");
    }

}
