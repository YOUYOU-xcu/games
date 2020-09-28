package cn.uu710.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 11:24
 */

public class BaseServlet extends HttpServlet {


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
//            获取子类，创建子类或者调用子类的对象，this代表的是子类对象
            String requestURI = request.getRequestURI();
//            System.out.println("requestURI是===="+requestURI);
//           获取请求方法
            String methodName = requestURI.substring(requestURI.lastIndexOf("/") + 1);
//            System.out.println("methodName是===="+methodName);
//            获取方法对象
//            System.out.println("this是"+this);
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
//            让方法执行,返回值为请求转发的路径
            String return_path = (String) method.invoke(this, request, response);
//            判空
            if (return_path!=null){
                request.getRequestDispatcher(return_path).forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
