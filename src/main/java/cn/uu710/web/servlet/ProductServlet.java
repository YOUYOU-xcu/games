package cn.uu710.web.servlet;

import cn.uu710.domain.Product;
import cn.uu710.service.ProductService;
import cn.uu710.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 16:01
 */
@WebServlet("/product/*")
public class ProductServlet extends BaseServlet{
    private ProductService productService = new ProductServiceImpl();
    public String detailsOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println("进来了……"+id);
        Product product = productService.detailsOne(id);
        request.setAttribute("product",product);
        System.out.println("本页商品为："+product);

       return "/user/product/product.jsp";

    }

/*
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    */
}
