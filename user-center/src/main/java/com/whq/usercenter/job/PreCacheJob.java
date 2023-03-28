package com.whq.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whq.usercenter.mapper.UserMapper;
import com.whq.usercenter.model.domain.User;
import com.whq.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: whq
 * @description: 缓存预热任务
 * @time: 2023/2/7 16:18
 */
@Component
@Slf4j
public class PreCacheJob {
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    // 重点用户
    private List<Long> mainUserList = Arrays.asList(1L);
    private ValueOperations<String, Object> valueOperations;

    @Scheduled(cron = "0 42 23 * * *")
    synchronized public void doCacheRecommendUser(){

        RLock lock = redissonClient.getLock("user-center:procachejob:docache:lock");
        try {
            // 只有一个线程能获取到锁 setnx
            // debug会出错 看门狗机制
            if (lock.tryLock(0,30000L, TimeUnit.MILLISECONDS)) {
                for (Long userId : mainUserList) {
                    // 无缓存，查数据库
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20, false), queryWrapper);
                    String redisKey = String.format("user-center:user:recommend:%s", userId);
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    // 写缓存
                    try {
                        valueOperations.set(redisKey, userPage,30000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }

        } catch (InterruptedException e) {
            log.error("doCacheRecommendUser error",e);
        } finally {
            // 只能释放自己的锁 要原子操作
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }


    }
}
