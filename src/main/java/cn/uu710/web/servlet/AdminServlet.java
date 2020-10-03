package cn.uu710.web.servlet;

import cn.uu710.domain.Admin;
import cn.uu710.domain.Product;
import cn.uu710.service.AdminService;
import cn.uu710.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:41
 */
@WebServlet("/a/*")
@MultipartConfig
public class AdminServlet extends BaseServlet {

    private AdminService adminService = new AdminServiceImpl();

    /**
     * 添加商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("添加商品………………");
        Product p = new Product();
        /**
         * 处理图片的上传
         */
        String path = getServletContext().getRealPath("/")+"upload";
        Part part = request.getPart("image");
        //获取请求头信息
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String filename = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
            System.out.println(filename);
        //从文件名称中截取文件后缀名abc.txt
        String suffix = filename.substring(filename.lastIndexOf("."));

        //存储的位置需要固定   存储到项目的发布路径下以便访问
        String newFileName = UUID.randomUUID().toString().replaceAll("-","")+suffix;
        part.write(path+"/"+filename);

        p.setProname(request.getParameter("proname"));
        p.setProsn(request.getParameter("prosn"));
        p.setProprice(Double.parseDouble(request.getParameter("proprice")));
        p.setPronum(Integer.parseInt(request.getParameter("pronum")));
//             System.out.println("proimg::::"+request.getParameter("proimg"));
        p.setProimg(newFileName);
//        p.setDesc(request.getParameter("desc"));
        p.setProfullname(request.getParameter("profullname"));
        p.setUnit(request.getParameter("unit"));

        System.out.println("准备添加的商品是："+p);

        boolean b = adminService.addProduct(p);
        if (b){
            response.getWriter().write("添加成功");
        }else {
            response.getWriter().write("添加失败");
        }

    }


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

    /**
     * 管理员修改个人密码
     */
    public void updatePass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        String mpass = request.getParameter("mpass");

        System.out.println(mpass.equals(admin.getPwd()));

        if (mpass.equals(admin.getPwd())){
            System.out.println("可以更改密码");
            String newpass = request.getParameter("newpass");
            String renewpass = request.getParameter("renewpass");

            if (! newpass.equals(renewpass)){
                response.getWriter().write("密码填写有误……");
                return;
            }

            admin.setPwd(renewpass);
            boolean b = adminService.updateAdmin(admin);

            if (!b){
                response.getWriter().write("密码填写有误……");
                return;
            }
            response.getWriter().write("修改成功……");
            response.sendRedirect(request.getContextPath());
            return;
        }

         response.getWriter().write("密码填写有误……");
    }

}