package cn.uu710.dao.impl;

import cn.uu710.dao.ProductDao;
import cn.uu710.domain.Product;
import cn.uu710.utils.JDBCUtils;
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
}
