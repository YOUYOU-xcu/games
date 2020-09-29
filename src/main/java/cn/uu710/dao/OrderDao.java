package cn.uu710.dao;

import cn.uu710.domain.Cart;
import cn.uu710.domain.Order;
import cn.uu710.domain.OrderItem;
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

    Cart findCartByCartId(int cartId);
    Order findOrderIdBySn(String sn);

    void createOrderItem(OrderItem orderItem);

    void toPay(String orderSn);

}
