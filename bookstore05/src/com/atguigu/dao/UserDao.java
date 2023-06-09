package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * @Author chenxin
 * @date 2022/3/8
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 功能：将user对象的数据保存到数据库
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 功能：根据用户名查找用户对象
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
