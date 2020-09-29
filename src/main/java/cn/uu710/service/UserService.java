package cn.uu710.service;

import cn.uu710.domain.Cart;
import cn.uu710.domain.Order;
import cn.uu710.domain.Product;
import cn.uu710.domain.User;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:49
 */

public interface UserService {
    User findOne(User u);
    List<Cart> findCart(User user);

    void deleteCartOne(String cartId);

    void deleteCartAll(int userId);

    List<Order> findOrder(User uu);

    void toPay(String orderSn);
}
