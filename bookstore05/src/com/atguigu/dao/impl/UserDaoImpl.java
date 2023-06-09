package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDaoImpl;
import com.atguigu.dao.UserDao;

/**
 * @Author chenxin
 * @date 2022/3/8
 * @Version 1.0
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public User findUserByUsername(String username) {
        String sql="select * from users where username=?";
        return this.getBean(User.class,sql,username);
    }

    @Override
    public boolean addUser(User user) {
        String sql="insert into users values(null,?,?,?)";
        int update = this.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        return update>0;
    }
}
