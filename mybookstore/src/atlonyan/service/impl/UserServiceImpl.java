package atlonyan.service.impl;

import atlonyan.bean.User;
import atlonyan.util.MD5Util;
import atlonyan.dao.impl.UserDaoImpl;
import atlonyan.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        String encode = MD5Util.encode(user.getPassword());
        user.setPassword(encode);
//        UserDaoImpl userDao = new UserDaoImpl();
        boolean b = userDao.addUser(user);
        return b;
    }

    @Override
    public boolean login(User user) {
//        UserDaoImpl userDao = new UserDaoImpl();
        User userByUsername = userDao.findUserByUsername(user.getUsername());
        String encode = MD5Util.encode(user.getPassword());
        if (userByUsername != null) {
            if (userByUsername.getPassword().equals(encode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserByUsername(String name) {
        return userDao.findUserByUsername(name);
    }

}
