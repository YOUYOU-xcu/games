package cn.uu710.dao;

import cn.uu710.domain.Admin;
import cn.uu710.domain.Product;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 13:45
 */

public interface AdminDao {
    Admin findAdmin(Admin admin);
    boolean updateAdmin(Admin admin);

    boolean addProduct(Product product);
}
