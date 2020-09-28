package cn.uu710.dao.impl;

import cn.uu710.dao.ProductDao;
import cn.uu710.domain.Cart;
import cn.uu710.domain.Product;
import cn.uu710.domain.User;
import cn.uu710.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:55
 */

public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 查询所有产品
     * @return
     */
    @Override
    public List<Product> findAllProduct() {
        String sql = "select * from product";
        return jt.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public Product detailsOne(int id) {
        String sql ="select * from product where id=?";
        return jt.queryForObject(sql,new BeanPropertyRowMapper<Product>(Product.class),id);
    }


    @Override
    public void addCart(int proId,int userId) {
        //从product表通过id查询此商品
        String sql1 ="select * from product where id=?";
        Product product = jt.queryForObject(sql1, new BeanPropertyRowMapper<Product>(Product.class), proId);
        System.out.println("进来了……");
        //插入此商品到购物车

        //查询此用户是否已有此商品，如果有则在原有基础上加1
        String sql2 = "select * from cart where product=?";

        Cart cartIsExist = null;
        try {
            cartIsExist = jt.queryForObject(sql2, new BeanPropertyRowMapper<Cart>(Cart.class), proId);
        } catch (DataAccessException e) {
                String sql4 = "update cart set num=num+1 where users=? and product=?";
                jt.update(sql4, userId,proId);
        }
        if (cartIsExist==null){
            String sql3 = "insert into cart(proimg,profullname,price,num,users,product) values(?,?,?,?,?,?)";
            jt.update(sql3,product.getProimg(),product.getProfullname(),product.getProprice(),1,userId,product.getId());
        }else {
            String sql4 = "update cart set num=num+1 where users=? and product=?";
            jt.update(sql4, userId,proId);
        }
    }
    @Override
    public void addCartOne(int proId,int userId) {
            String sql4 = "update cart set num=num+1 where users=? and product=?";
            jt.update(sql4, userId,proId);
    }

    @Override
    public void downCartOne(int proId,int userId) {
            String sql4 = "update cart set num=num-1 where users=? and product=?";
            jt.update(sql4, userId,proId);
    }

}
