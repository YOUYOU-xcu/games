package cn.uu710.dao;

import cn.uu710.domain.User;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:45
 */

public interface UserDao {
    User findOne(User u);
}
