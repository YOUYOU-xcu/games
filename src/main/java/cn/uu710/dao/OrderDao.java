package cn.uu710.dao;

import cn.uu710.domain.Order;
import cn.uu710.domain.User;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-28 12:03
 */

public interface OrderDao {
    void createOrder(Order order);
    List<Order> findOrder(User uu);
}
