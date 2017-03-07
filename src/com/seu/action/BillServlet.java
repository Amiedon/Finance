package com.seu.action;

import com.seu.dao.PayInOutDao;
import com.seu.dao.impl.PayInOutImpl;
import com.seu.entity.PayIn;
import com.seu.entity.PayOut;
import com.seu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Amie on 2017/3/6.
 */
@WebServlet(name = "BillServlet",urlPatterns = {"/servlet/BillServlet"})
public class BillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");////得到user对象
        if (user == null)
        {
            System.out.println("请重新登陆");
            request.getRequestDispatcher("../html/login.jsp").forward(request,response);
        }
        else
        {
            //将账单信息插入数据库
            if (request.getParameter("consume").equals("consume")) {/////消费账单
                PayOut payOut = new PayOut();
                payOut.setPayOutMoney(Float.parseFloat(request.getParameter("money")));
                payOut.setPayOutDate(request.getParameter("date"));
                payOut.setNote(request.getParameter("comment"));
                payOut.setUserId(user.getId());
                payOut.setPayOutCategory(request.getParameter("category"));
                PayInOutDao payInOut = new PayInOutImpl();
                if (payInOut.addPayOut(payOut))
                {
                    System.out.println("账单插入成功");
                }
            }
            else if(request.getParameter("consume").equals("income"))///////收入账单
            {
                PayIn payIn = new PayIn();
                payIn.setPayInMoney(Float.parseFloat(request.getParameter("money")));
                payIn.setPayInDate(request.getParameter("date"));
                payIn.setNote(request.getParameter("comment"));
                payIn.setUserId(user.getId());
                PayInOutDao payInOut = new PayInOutImpl();
                if (payInOut.addPayIn(payIn))
                {
                    System.out.println("账单插入成功");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
