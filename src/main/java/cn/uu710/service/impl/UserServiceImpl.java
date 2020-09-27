package cn.uu710.service.impl;

import cn.uu710.dao.UserDao;
import cn.uu710.dao.impl.UserDaoImpl;
import cn.uu710.domain.User;
import cn.uu710.service.UserService;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:50
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findOne(User u) {
        return userDao.findOne(u);
    }
}
