package cn.uu710.dao.impl;

import cn.uu710.dao.OrderDao;
import cn.uu710.domain.Order;
import cn.uu710.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-28 12:03
 */

public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void createOrder(Order order) {

        String sql = "insert into order values(?,?,?,?,?,?)";
//        默认订单初始状态为100
        jt.update(sql,null,order.getUsers(),order.getSn(),order.getTotalprice(), order.getCreatedate(),100);
    }
}
