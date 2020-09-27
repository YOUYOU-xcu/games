package cn.uu710.service.impl;

import cn.uu710.dao.impl.ProductDaoImpl;
import cn.uu710.domain.Cart;
import cn.uu710.domain.Product;
import cn.uu710.service.ProductService;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:56
 */

public class ProductServiceImpl implements ProductService {
    ProductDaoImpl productDao = new ProductDaoImpl();
    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }

    @Override
    public Product detailsOne(String id) {
        int i = Integer.parseInt(id);
        return productDao.detailsOne(i);
    }

    @Override
    public void addCart(String proId,int userId) {
        int pid = Integer.parseInt(proId);

        productDao.addCart(pid,userId);
    }
}
