package cn.uu710.service.impl;

import cn.uu710.dao.OrderDao;
import cn.uu710.dao.impl.OrderDaoImpl;
import cn.uu710.domain.Cart;
import cn.uu710.domain.Order;
import cn.uu710.domain.OrderItem;
import cn.uu710.service.OrderService;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-28 12:02
 */

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public Cart findCartByCartId(String cartId) {
        int i = Integer.parseInt(cartId);
        return orderDao.findCartByCartId(i);
    }

    @Override
    public Order findOrderIdBySn(String sn) {
        return orderDao.findOrderIdBySn(sn);
    }

    @Override
    public void createOrderItem(OrderItem orderItem) {
        orderDao.createOrderItem(orderItem);
    }
}
