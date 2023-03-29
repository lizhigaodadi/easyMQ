package com.lzg.easymq.user;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class UserLogin {
    public static HashMap<String,User> userStorage;   // 用于客户端连接时的用户登陆功能

    public static boolean setUser(User user) {
        String userName = user.getUsername();
        if (userStorage.containsKey(userName)) {   // 存在重复的用户
            System.out.println("username: " + userName + " 重复创建");
            return false;
        } else {
            userStorage.put(userName, user);
        }
        return true;

    }
}
