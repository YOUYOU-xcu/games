package cn.uu710.dao;

import cn.uu710.domain.Cart;
import cn.uu710.domain.Product;

import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:54
 */

public interface ProductDao {
   List<Product> findAllProduct();

   Product detailsOne(int id);

   List<Cart> findCart(int id);
   void addCart(int proId,int userId);

}
