package atlonyan.service;

import atlonyan.bean.User;

public interface UserService {
    boolean regist(User user);
    boolean login(User user);
    User getUserByUsername(String name);
}
