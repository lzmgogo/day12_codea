package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * @Author chenxin
 * @date 2022/3/8
 * @Version 1.0
 */
public interface UserService {
    /**
     * 功能：注册
     * @param user
     * @return
     */
    boolean regist(User user);

    /**
     * 功能：登录
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);

    /**
     * 检查用户名是否重复
     * @param username
     * @return
     */
    User checkUsername(String username);
}
