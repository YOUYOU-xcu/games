package cn.uu710.web.servlet;

import cn.uu710.domain.Product;
import cn.uu710.service.ProductService;
import cn.uu710.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:35
 */

@WebServlet("/index/*")
public class IndexServlet extends BaseServlet {

    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "/user/index.jsp";

    }


}
