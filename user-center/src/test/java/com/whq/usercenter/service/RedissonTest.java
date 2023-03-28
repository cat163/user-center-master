package com.whq.usercenter.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: whq
 * @description:
 * @time: 2023/2/9 16:43
 */
@SpringBootTest
public class RedissonTest {
    @Resource
    private RedissonClient redissonClient;


    @Test
    public void test(){
        // list, 数据存在本地的 JVN内存中
        List<String> list = new ArrayList<>();
        list.add("dog");
        System.out.println("list：" + list.get(0));
//        list.remove(0);

        // 数据存在 redis 内存中
        RList<String> rList = redissonClient.getList("test-list");
//        rList.add("dog");
        System.out.println("rlist：" + rList.get(0));
        rList.remove(0);

        // map
        Map<String,Integer> map = new HashMap<>();
        map.put("dog",10);
        map.remove("dog");

        RMap<Object, Object> map1 = redissonClient.getMap("test-map");

        //set

    }
}
