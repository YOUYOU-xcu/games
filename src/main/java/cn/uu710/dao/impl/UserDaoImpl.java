package cn.uu710.dao.impl;

import cn.uu710.dao.UserDao;
import cn.uu710.domain.Cart;
import cn.uu710.domain.Product;
import cn.uu710.domain.User;
import cn.uu710.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:45
 */

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 用户删除商品
     */
    public void deleteCartOne(int cartId){
        String sql = "delete from cart where id=?";
        jt.update(sql,cartId);

    }
    public void deleteCartAll(int userId){
        String sql = "delete from cart where users=?";
        jt.update(sql,userId);
    }

    @Override
    public List<Cart> findCart(int id) {
        String sql = "select * from cart where users = ?";
        try {
            List<Cart> query = jt.query(sql, new BeanPropertyRowMapper<Cart>(Cart.class),id);
            return query;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 查询登录用户
     * @return
     */

    @Override
    public User findOne(User u) {
        User user = null;
        String sql = "select * from user where loginname=? and pwd=?";
        try {
            user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), u.getLoginname(), u.getPwd());
            return user;
        } catch (DataAccessException e) {
//            e.printStackTrace();
            System.out.println("找不到该用户……");
        }
        return user;

    }
}