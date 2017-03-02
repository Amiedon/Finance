package com.seu.action;

import com.seu.dao.UserDao;
import com.seu.dao.impl.UserDaoImpl;
import com.seu.entity.User;
import com.seu.util.MailUtils;
import com.seu.util.UUIDUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amie on 2017/3/1.
 */
@WebServlet(name = "RegisterAction",urlPatterns = {"/servlet/RegisterAction"})
public class RegisterAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        /*PrintWriter out = response.getWriter();*/

       /* String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("username = " + username + "  email = " + email
                +" password = " + password);*/
        //  接受数据
        String username = request.getParameter("user");
        String email = request.getParameter("email");
        String password = request.getParameter("passwd");
        System.out.println("username = " + username + "  email = " + email
                +" password = " + password);
        //封装数据
        User user = new User();
        UserDao userDao = new UserDaoImpl();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoto("test");
        user.setState(0);//0: 未激活 1： 已激活
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();//64位激活码
        user.setCode(code);
        //调用业务层处理数据
        if (userDao.add(user))
        {
            System.out.println("数据插入成功！");
        }
        else System.out.println("数据插入失败！");

        try {
            MailUtils.sendMail(user.getEmail(),user.getCode());
            System.out.println("请去邮箱验证");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
