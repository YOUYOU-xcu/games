package cn.uu710.dao.impl;

import cn.uu710.dao.AdminDao;
import cn.uu710.domain.Admin;
import cn.uu710.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
}