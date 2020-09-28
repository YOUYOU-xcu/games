package cn.uu710.service.impl;

import cn.uu710.dao.OrderDao;
import cn.uu710.dao.impl.OrderDaoImpl;
import cn.uu710.domain.Order;
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
}
