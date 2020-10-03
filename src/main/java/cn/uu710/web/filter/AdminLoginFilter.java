package cn.uu710.web.filter;

import cn.uu710.domain.Admin;
import cn.uu710.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:06
 */
@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //1.强转
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;

        //2.业务逻辑
        //从session中获取admin 判断admin是否为空 若为空 请求转发
        Admin admin = (Admin) req.getSession().getAttribute("admin");

        String uri = req.getRequestURI();
//        System.out.println("过滤器是否过滤："+uri);
        if (uri.contains("/login.jsp")|| uri.contains("/css")
                || uri.contains("/js") || uri.contains("/checkCodeServlet")
                || uri.contains("/img")){
            //放行
            chain.doFilter(req, resp);
        }else {
            if (admin != null) {
                //放行
                chain.doFilter(req, resp);
            } else {
                //跳转到登录界面
                request.setAttribute("errorMsg", "请登录!");
                request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
