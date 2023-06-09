package atlonyan.dao;

import atlonyan.bean.User;

public interface UserDao {
    boolean addUser(User user);
    User findUserByUsername(String username);
}
