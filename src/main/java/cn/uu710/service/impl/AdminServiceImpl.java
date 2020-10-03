package cn.uu710.service.impl;

import cn.uu710.dao.AdminDao;
import cn.uu710.dao.impl.AdminDaoImpl;
import cn.uu710.domain.Admin;
import cn.uu710.domain.Product;
import cn.uu710.service.AdminService;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:50
 */

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin findAdmin(Admin admin) {
        return adminDao.findAdmin(admin);
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public boolean addProduct(Product product) {
       return adminDao.addProduct(product);
    }


}
