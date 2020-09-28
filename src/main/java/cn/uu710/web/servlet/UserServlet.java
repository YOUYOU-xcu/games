package cn.uu710.web.servlet;

import cn.uu710.domain.Cart;
import cn.uu710.domain.User;
import cn.uu710.service.ProductService;
import cn.uu710.service.UserService;
import cn.uu710.service.impl.ProductServiceImpl;
import cn.uu710.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:41
 */
@WebServlet("/u/*")
public class UserServlet extends BaseServlet {
    private ProductService productService = new ProductServiceImpl();
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

    /**
     * 添加购物车，以及显示购物车
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String cartList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User uu = (User) request.getSession().getAttribute("user");
        List<Cart> cartList = userService.findCart(uu);

        request.setAttribute("cartList",cartList);
        return "/user/cart/list.jsp";
    }

    public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println(request.getSession().getAttribute("user")+"正在执行添加购物车……");
//        判断用户是否已经登录
        User uu = (User) request.getSession().getAttribute("user");
        if (uu==null){//未登录
            out.write("failure");
            return;
        }
        String proId = request.getParameter("proId");
        System.out.println("proId=="+proId+",uu.getId()=="+uu.getId());
        productService.addCart(proId, uu.getId());
        out.write("success");
    }

    /**
     * 购物车内的数量增加与减少
     */
    public void addCartOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("user")+"正在增加一个商品……");
        User uu = (User) request.getSession().getAttribute("user");
        String proId = request.getParameter("proId");
        int i = Integer.parseInt(proId);
        productService.addCartOne(i, uu.getId());
        response.sendRedirect(request.getContextPath()+"/u/cartList");
    }
    public void downCartOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("user")+"正在减少一个商品……");
        User uu = (User) request.getSession().getAttribute("user");
        String proId = request.getParameter("proId");
        int i = Integer.parseInt(proId);
        productService.downCartOne(i, uu.getId());
        response.sendRedirect(request.getContextPath()+"/u/cartList");
    }

    /**
     * 创建订单，以及显示订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("创建订单……");

    }

    public String orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        return "/user/order/list.jsp";

    }

    /**
     * 购物车内的删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteCartOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cartId = request.getParameter("cartId");
        System.out.println("正在删除此商品==="+cartId);
        userService.deleteCartOne(cartId);
        System.out.println("已经删除了商品==="+cartId);
        response.sendRedirect(request.getContextPath()+"/u/cartList");

    }
    public void deleteCartAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        userService.deleteCartAll(user.getId());
        System.out.println("已经清空了购物车");

        response.sendRedirect(request.getContextPath()+"/u/cartList");

    }
/*

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
*/

}