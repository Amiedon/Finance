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
import java.util.List;

/**
 * 用户激活的servlet
 * Created by Amie on 2017/3/2.
 */
@WebServlet(name = "ActiveServlet",urlPatterns = {"/servlet/ActiveServlet"})
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收激活码
        String code = request.getParameter("code");
        System.out.println(code);
        //根据激活码查询用户
        List<User> list;
        UserDao userDao = new UserDaoImpl();
        list = userDao.findSimpleResult("select * from user where code = ?",code);
        if (list.size()>0)//已经查询到
        {
            list.get(0).setState(1);//修改激活状态并删去激活码
            list.get(0).setCode(null);
            userDao.change(list.get(0));//更新用户数据表
            System.out.println("已经激活");
            //跳转成功激活页面
        }
        else{
            //激活码有误
            System.out.println("激活码有误");
            //跳转错误页面
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
