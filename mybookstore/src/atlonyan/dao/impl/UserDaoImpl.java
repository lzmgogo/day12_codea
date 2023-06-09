package atlonyan.dao.impl;

import atlonyan.bean.User;
import atlonyan.dao.BaseDAOImpl;
import atlonyan.dao.UserDao;

import java.sql.SQLException;

public class UserDaoImpl extends BaseDAOImpl implements UserDao {
    @Override
    public boolean addUser(User user) {
        String sql="INSERT INTO users VALUES(0,?,?,?)";
        try {
            return update(sql,user.getUsername(),user.getPassword(),user.getEmail())>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByUsername(String username) {
        String sql="SELECT * FROM users WHERE username=?";
        try {
            return getBean(User.class,sql,username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
