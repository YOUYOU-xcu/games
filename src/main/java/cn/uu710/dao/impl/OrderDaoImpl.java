package cn.uu710.dao.impl;

import cn.uu710.dao.OrderDao;
import cn.uu710.domain.Cart;
import cn.uu710.domain.Order;
import cn.uu710.domain.OrderItem;
import cn.uu710.domain.User;
import cn.uu710.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-28 12:03
 */

public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void createOrder(Order order) {
        System.out.println("正在创建订单………………");
        String sql = "insert into `order`(id,users,sn,totalPrice,createdate,status) values(?,?,?,?,?,?)";
//        默认订单初始状态为0
        int update = jt.update(sql, null, order.getUsers(), order.getSn(), order.getTotalprice(), order.getCreatedate(), 0);
    }

    @Override
    public List<Order> findOrder(User uu) {
        List<Order> query = null;
        String sql = "select * from `order` where users=?";

        try {
            query= jt.query(sql, new BeanPropertyRowMapper<>(Order.class), uu.getId());
            return query;
        } catch (DataAccessException e) {
            System.out.println("此用户无订单");
            return query;
        }
    }

    @Override
    public Order findOrderIdBySn(String sn) {
        Order query = null;
        String sql = "select * from `order` where sn=?";

        try {
            query = jt.queryForObject(sql, new BeanPropertyRowMapper<Order>(Order.class),sn);
            System.out.println(query+"通过订单号查询订单数据");
            return query;
        } catch (DataAccessException e) {
            System.out.println("此用户无订单");
            return query;
        }
    }

    @Override
    public Cart findCartByCartId(int cartId) {
        Cart query = null;
        String sql = "select * from cart where id=?";

        try {
            query = jt.queryForObject(sql, new BeanPropertyRowMapper<Cart>(Cart.class),cartId);
            System.out.println(query+"通过购物id查询的购物数据");
            return query;
        } catch (DataAccessException e) {
            System.out.println("此用户无订单");
            return query;
        }
    }

    @Override
    public void createOrderItem(OrderItem orderItem){
        String sql = "insert into orderitem values(?,?,?,?,?)";
        jt.update(sql,null,orderItem.getOrders(),orderItem.getProduct(),orderItem.getNum(),orderItem.getPrice());

    }

    @Override
    public void toPay(String orderSn) {
        String sql ="update `order` set status=1 where sn=?";
        jt.update(sql,orderSn);
    }

}
