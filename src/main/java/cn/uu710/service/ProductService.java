package cn.uu710.service;

import cn.uu710.domain.Product;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:56
 */

public interface ProductService {
    List<Product> findAllProduct();
    Product detailsOne(String id);
}
