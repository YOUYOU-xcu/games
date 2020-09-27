package cn.uu710.web.filter;

import cn.uu710.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:06
 */
//@WebFilter
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //1.强转
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;

        //2.业务逻辑
        //从session中获取user 判断user是否为空 若为空 请求转发
        User user=(User) req.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("msg", "没有权限,请先登录!");
            request.getRequestDispatcher("/jsp/msg.jsp").forward(request, response);
            return;
        }

        //3.放行
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
