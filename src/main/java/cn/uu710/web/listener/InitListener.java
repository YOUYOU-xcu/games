package cn.uu710.web.listener;

import cn.uu710.service.impl.ProductServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 10:16
 */
@WebListener
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("path",servletContext.getContextPath());
        servletContext.setAttribute("upload",servletContext.getContextPath()+"/upload");
        servletContext.setAttribute("items",new ProductServiceImpl().findAllProduct());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
