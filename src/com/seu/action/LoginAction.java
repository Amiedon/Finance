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
import java.util.List;

/**
 * Created by Amie on 2017/3/1.
 */
@WebServlet(name = "LoginAction",urlPatterns = {"/servlet/LoginAction"})
public class LoginAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("userpwd");
        List<User> list;
        UserDao userDao = new UserDaoImpl();
        list = userDao.findSimpleResult("select * from user where username = ?",username);
        if(list.size()!=0) {
            if ((password.equals(list.get(0).getPassword())) && (list.get(0).getState()!=0)) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败，请检查用户名和密码");
                PrintWriter out = response.getWriter();
                out.println("登录失败，请检查用户名和密码 ");
                request.setAttribute("from","login");
                request.getRequestDispatcher("../html/msg.jsp").forward(request, response);
            }
        }
        else
        {
            System.out.println("登录失败，请检查用户名和密码");
            request.setAttribute("from","login");
            request.getRequestDispatcher("../html/msg.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
