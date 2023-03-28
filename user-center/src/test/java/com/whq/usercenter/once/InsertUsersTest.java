package com.whq.usercenter.once;


import com.whq.usercenter.model.domain.User;
import com.whq.usercenter.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class InsertUsersTest {

    @Resource
    private UserService userService;

    /**
     * 批量查询
     */
//    @Scheduled(initialDelay = 1000, fixedRate = Long.MAX_VALUE)
    @Test
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 1000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("fakeName");
            user.setUserAccount("fakeAccount");
            user.setAvatarUrl("https://images.ctfassets.net/hrltx12pl8hq/01rJn4TormMsGQs1ZRIpzX/02e9885a9ae69312da844bc58eedced1/Artboard_Copy_22.png?fit=fill&w=600&h=400");
            user.setGender(0);
            user.setUserProfile("");
            user.setUserPassword("123123");
            user.setPhone("123123");
            user.setEmail("123@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setTags("[]");
            userList.add(user);
        }
        userService.saveBatch(userList,100);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrencyInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int batchSize = 250000;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(40, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));
        // 分10组
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            List<User> userList = new ArrayList<>();
            while (true){
                j++;
                User user = new User();
                user.setUsername("fakeName");
                user.setUserAccount("fakeAccount");
                user.setAvatarUrl("https://images.ctfassets.net/hrltx12pl8hq/01rJn4TormMsGQs1ZRIpzX/02e9885a9ae69312da844bc58eedced1/Artboard_Copy_22.png?fit=fill&w=600&h=400");
                user.setGender(0);
                user.setUserProfile("");
                user.setUserPassword("123123");
                user.setPhone("123123");
                user.setEmail("123@qq.com");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setTags("[]");
                userList.add(user);
                if (j % batchSize == 0){
                    break;
                }
            }
            // 异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("ThreadName：" + Thread.currentThread().getName());
                userService.saveBatch(userList, 5000);
            },threadPoolExecutor);
            futureList.add(future);
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}