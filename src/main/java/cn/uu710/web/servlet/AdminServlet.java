package cn.uu710.web.servlet;

import cn.uu710.domain.Admin;
import cn.uu710.domain.User;
import cn.uu710.service.AdminService;
import cn.uu710.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:41
 */
@WebServlet("/a/*")
public class AdminServlet extends BaseServlet {

    private AdminService adminService = new AdminServiceImpl();

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin!=null){
            response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
            return;
        }
        request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
    }

    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admin admin = new Admin();
        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        admin.setLoginname(loginname);
        admin.setPwd(password);
        Admin loginAdmin = adminService.findAdmin(admin);

        if (loginAdmin!=null){
            request.getSession().setAttribute("admin",loginAdmin);
            response.sendRedirect(request.getContextPath()+"/a/index");
        }else {
            request.setAttribute("errorMsg", "用户名或密码错误，请重新输入");
            request.setAttribute("loginname",loginname);

            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute("admin");

        response.sendRedirect(request.getContextPath());
    }


}