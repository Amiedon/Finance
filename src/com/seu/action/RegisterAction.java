package com.seu.action;

import com.seu.dao.UserDao;
import com.seu.dao.impl.UserDaoImpl;
import com.seu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Amie on 2017/3/1.
 */
@WebServlet(name = "RegisterAction",urlPatterns = {"/servlet/RegisterAction"})
public class RegisterAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        /*PrintWriter out = response.getWriter();*/
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("username = " + username + "  email = " + email
                +" password = " + password);
        User user = new User();
        UserDao userDao = new UserDaoImpl();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoto("test");
        if (userDao.add(user))
        {
            System.out.println("数据插入成功！");
        }
        else System.out.println("数据插入失败！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
