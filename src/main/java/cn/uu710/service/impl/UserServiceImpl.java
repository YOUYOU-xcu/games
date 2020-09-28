package cn.uu710.service.impl;

import cn.uu710.dao.OrderDao;
import cn.uu710.dao.UserDao;
import cn.uu710.dao.impl.OrderDaoImpl;
import cn.uu710.dao.impl.UserDaoImpl;
import cn.uu710.domain.Cart;
import cn.uu710.domain.Order;
import cn.uu710.domain.User;
import cn.uu710.service.UserService;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:50
 */

public class UserServiceImpl implements UserService {
    private OrderDao orderDao = new OrderDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findOne(User u) {
        return userDao.findOne(u);
    }

    @Override
    public List<Cart> findCart(User user) {
        return userDao.findCart(user.getId());
    }

    /**
     * 用户删除商品
     */
    public void deleteCartOne(String cartId){
        int i = Integer.parseInt(cartId);
        userDao.deleteCartOne(i);

    }
    public void deleteCartAll(int userId){
        userDao.deleteCartAll(userId);
    }

    @Override
    public List<Order> findOrder(User uu) {
        return orderDao.findOrder(uu);
    }
}
