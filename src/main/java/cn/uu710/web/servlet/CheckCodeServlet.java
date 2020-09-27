package cn.uu710.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @version 1.0
 * @author： 张佑
 * @date： 2020-09-27 14:33
 */

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");

        /**
         * 在内存中创建一个长度为80，宽度为30的图片，默认黑色背景
         *
         */
        int width =80;
        int height=30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔的颜色为灰色
        g.setColor(Color.gray);
        //填充图片
        g.fillRect(0,0,width,height);

        //产生4位验证码
        String checkCode = getCheckCode();
        request.getSession().setAttribute("CHECKCODE_SERVER",checkCode);

        //设置画笔的颜色为黄色
        g.setColor(Color.yellow);
        //设置字体的大小
        g.setFont(new Font("黑体",Font.BOLD,24));
        //把验证码写入到图片上
        g.drawString(checkCode,15,25);

        //将内存中的图片输出到浏览器
        ImageIO.write(image,"PNG",response.getOutputStream());

    }

    public String getCheckCode(){

        String base = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz23456789";
        int size = base.length();
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=1;i<=4;i++){
//            产生0到size-1的随机值
            int index = random.nextInt(size);
            char c = base.charAt(index);
            stringBuffer.append(c);
        }
        System.out.println("本次生成的验证码是："+stringBuffer);

        return stringBuffer.toString();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
