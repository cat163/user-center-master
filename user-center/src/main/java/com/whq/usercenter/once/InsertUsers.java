package com.whq.usercenter.once;
import java.util.Date;

import com.whq.usercenter.mapper.UserMapper;
import com.whq.usercenter.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * @author: whq
 * @description:
 * @time: 2023/2/5 14:39
 */
@Component
public class InsertUsers {

    @Resource
    private UserMapper userMapper;

//    @Scheduled(initialDelay = 1000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
//        final int INSERT_NUM = 10000000;
//        for (int i = 0; i < INSERT_NUM; i++) {
//            User user = new User();
//            user.setUsername("fakeName");
//            user.setUserAccount("fakeAccount");
//            user.setAvatarUrl("https://images.ctfassets.net/hrltx12pl8hq/01rJn4TormMsGQs1ZRIpzX/02e9885a9ae69312da844bc58eedced1/Artboard_Copy_22.png?fit=fill&w=600&h=400");
//            user.setGender(0);
//            user.setUserProfile("");
//            user.setUserPassword("123123");
//            user.setPhone("123123");
//            user.setEmail("123@qq.com");
//            user.setUserStatus(0);
//            user.setUserRole(0);
//            user.setTags("[]");
//
//            userMapper.insert(user);
//        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
