package cn.uu710.web.servlet;

import cn.uu710.domain.Cart;
import cn.uu710.domain.Order;
import cn.uu710.domain.OrderItem;
import cn.uu710.domain.User;
import cn.uu710.service.OrderService;
import cn.uu710.service.ProductService;
import cn.uu710.service.UserService;
import cn.uu710.service.impl.OrderServiceImpl;
import cn.uu710.service.impl.ProductServiceImpl;
import cn.uu710.service.impl.UserServiceImpl;
import cn.uu710.utils.UuidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private OrderService orderService = new OrderServiceImpl();

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
        User uu = (User) request.getSession().getAttribute("user");
        System.out.println(uu+"正在尝试执行添加购物车……");
//        判断用户是否已经登录
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
        System.out.println(request.getSession().getAttribute("user")+"正在尝试增加一个商品……");
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
//        PrintWriter out = response.getWriter();
        Order order = new Order();
//        创建此用户的订单
        User user = (User) request.getSession().getAttribute("user");

        order.setUsers(user.getId());//用户id
        order.setSn(UuidUtil.getUuid());//订单号
        order.setCreatedate(new Date());//创建订单时间
            String sum = request.getParameter("sum");
            System.out.println("sum总价为"+sum);
            double totalPrice = Double.parseDouble(sum);
        order.setTotalprice(totalPrice);    //  总价

        System.out.println(order.toString());
//        调用方法，将订单信息存入数据库
        orderService.createOrder(order);

        /**
         * 获取用户的多选商品创建的订单所对应的商品，准备执行删除操作
         */
        String duoxuan = request.getParameter("duoxuan");
        System.out.println("用户正在创建订单的商品："+duoxuan);
        String[] splitResult = duoxuan.split(",");


        /**创建订单项
         *
         * 订单id
         * 商品id
         */

        for (String cartIds:splitResult){
            OrderItem orderItem = new OrderItem();
            //通过cartId查询准备结算的商品信息
            Cart cartByCartId = orderService.findCartByCartId(cartIds);
            Order orderIdBySn = orderService.findOrderIdBySn(order.getSn());

            //订单id，通过订单号查询
            orderItem.setOrders(orderIdBySn.getId());
//        订单所对应的商品id，此时cart未删除，可查询到
            orderItem.setProduct(cartByCartId.getProduct());
//        订单所对应的商品id所对应的数量，此时cart未删除，可查询到
            orderItem.setNum(cartByCartId.getNum());
//        订单所对应的商品id所对应的数量金额，此时cart未删除，可查询到，并计算
            orderItem.setPrice(cartByCartId.getPrice()*cartByCartId.getNum());

            //调用方法，插入订单项
            orderService.createOrderItem(orderItem);

            /**
             * 删除此用户的购物车内的已经创建订单项的购物商品信息
             */
            System.out.println("需要删除购物车里的这一项："+cartIds);
            userService.deleteCartOne(cartIds);

        }

        System.out.println("成功创建订单……");

        /**
         * 订单创建完成之后跳转到用户订单页面
         */
        response.sendRedirect(request.getContextPath()+"/u/orderList");

    }

    /**
     * 显示订单
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User uu = (User) request.getSession().getAttribute("user");
        List<Order> orders = userService.findOrder(uu);

        if (orders==null){
            return null;
        }else {
            request.setAttribute("orderList", orders);

            return "/user/order/list.jsp";
        }
    }

    /**
     * 购物车内的删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteCartAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("用户正在清空购物车");
        User user = (User) request.getSession().getAttribute("user");
        userService.deleteCartAll(user.getId());
        response.sendRedirect(request.getContextPath()+"/u/cartList");
    }

    public void deleteCartOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cartId = request.getParameter("cartId");
        userService.deleteCartOne(cartId);
        response.sendRedirect(request.getContextPath()+"/u/cartList");

    }


}