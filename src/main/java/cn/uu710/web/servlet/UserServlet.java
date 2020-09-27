package cn.uu710.web.servlet;

import cn.uu710.domain.User;
import cn.uu710.service.UserService;
import cn.uu710.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:41
 */
@WebServlet("/u/*")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private User user = new User();

    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        user.setLoginname(loginname);
        user.setPwd(password);

        User one = userService.findOne(user);

        if (one!=null){
            request.getSession().setAttribute("user",one);
//            System.out.println("登录用户为："+one+"  "+one.getLoginname()+" "+ one.getUsername());
            response.sendRedirect(request.getContextPath());
        }else {
            request.setAttribute("errorMsg", "用户名或密码错误，请重新输入");
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute("user");

        response.sendRedirect(request.getContextPath());
    }

    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("注册……");
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(user,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
*/

}