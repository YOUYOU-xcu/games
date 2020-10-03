package cn.uu710.dao.impl;

import cn.uu710.dao.AdminDao;
import cn.uu710.domain.Admin;
import cn.uu710.domain.Product;
import cn.uu710.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:45
 */

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询登录用户
     * @return
     */

    @Override
    public Admin findAdmin(Admin admin) {
        Admin admin1 = null;
        String sql = "select * from admin where loginname=? and pwd=?";
        try {
            admin1 = jt.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), admin.getLoginname(), admin.getPwd());
            return admin1;
        } catch (DataAccessException e) {
//            e.printStackTrace();
            System.out.println("找不到该管理员……");
        }
        return admin1;

    }

    @Override
    public boolean updateAdmin(Admin admin) {
        String sql = "update admin set pwd=? where loginname=?";
        int update = jt.update(sql,admin.getPwd(), admin.getLoginname());
        if (update>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addProduct(Product product) {
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?,?)";
        int update = jt.update(sql, null, product.getProname(),
                product.getProsn(), product.getProprice(),
                product.getPronum(), product.getProimg(),
                null, product.getProfullname(),
                product.getUnit(), new Date(), 0);
        if (update>0){
            return true;
        }else {
            return false;
        }
    }
}