package cn.uu710.service;

import cn.uu710.domain.Cart;
import cn.uu710.domain.Order;
import cn.uu710.domain.OrderItem;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-28 12:02
 */

public interface OrderService {
    void createOrder(Order order);
    Cart findCartByCartId(String cartId);
    Order findOrderIdBySn(String sn);
    void createOrderItem(OrderItem orderItem);
}
