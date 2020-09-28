package cn.uu710.dao;

import cn.uu710.domain.Cart;
import cn.uu710.domain.User;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:45
 */

public interface UserDao {
    User findOne(User u);
    List<Cart> findCart(int id);
    /**
     * 用户删除商品
     */
    void deleteCartOne(int cartId);

    void deleteCartAll(int userId);
}
