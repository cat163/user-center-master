package com.whq.usercenter.service;

import com.whq.usercenter.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @author whq
 */
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("whq");
        user.setUserAccount("123");
        user.setAvatarUrl("https://i0.hdslb.com/bfs/face/member/noface.jpg@120w_120h_1c.webp");
        user.setGender(0);
        user.setUserPassword("123123");
        user.setPhone("1112");
        user.setEmail("1112");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
//        String userAccount = "whqtt";
//        String userPassword = "12345678";
//        String checkPassword = "1234567";
//        String idCode = "1";
//        long result = userService.userRegister(userAccount, userPassword, checkPassword,idCode);
//        Assertions.assertEquals(-1,result,"密码和确定密码不一");
//        userAccount = "wu";
//        result = userService.userRegister(userAccount, userPassword, checkPassword,idCode);
//        Assertions.assertEquals(-1,result,"用户账号名称小于4位");
//        userAccount = "whqtt";
//        userPassword = "1234567";
//        checkPassword = "1234567";
//        result = userService.userRegister(userAccount, userPassword, checkPassword,idCode);
//        Assertions.assertEquals(-1,result,"密码小于8位");
//        userPassword = "12345678";
//        checkPassword = "12345678";
//        userAccount = "whq  tt";
//        result = userService.userRegister(userAccount, userPassword, checkPassword,idCode);
//        Assertions.assertEquals(-1,result,"账号名称含有特殊字符");
//        userAccount = "1234";
//        result = userService.userRegister(userAccount, userPassword, checkPassword,idCode);
//        Assertions.assertEquals(-1,result,"该用户存在");
//        userAccount = "whqtt";
//        result = userService.userRegister(userAccount, userPassword, checkPassword,idCode);
//        Assertions.assertTrue(result > 0,"插入成功");
    }

    @Test
    void searchUserByTags() {
        List<String> tagNameList = Arrays.asList("java","python");
        List<User> userList = userService.searchUserByTags(tagNameList);
        System.out.println(userList);
        Assert.assertNotNull(userList);
    }
}