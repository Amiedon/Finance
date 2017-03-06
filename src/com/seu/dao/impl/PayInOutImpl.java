package com.seu.dao.impl;

import com.seu.dao.PayInOutDao;
import com.seu.entity.PayIn;
import com.seu.entity.PayOut;
import com.seu.entity.User;
import com.seu.util.JDBCTools;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */
public class PayInOutImpl implements PayInOutDao {
    Statement statement = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;

    /*payout表中插入支出记录，userId为已经登录的用户的id*/
    public boolean addPayOut(PayOut payOut) {
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into payout(id,payOutDate,payOutMoney,payOutCategory,userId,note) " +
                    "values(?,?,?,?,?,?)";
            JDBCTools.update(sql, payOut.getId(), payOut.getPayOutDate(), payOut.getPayOutMoney(),
                    payOut.getPayOutCategory(), payOut.getUserId(), payOut.getNote());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(null, null, connection);
        }
        return true;
    }

    //payin表中增加记录，userId为已经登录的用户的id
    public boolean addPayIn(PayIn payIn) {
        try {
            connection = JDBCTools.getConnection();
            String sql = "insert into payin(id,payInDate,payInMoney,note,userId)" +
                    "values(?,?,?,?,?)";
            JDBCTools.update(sql, payIn.getId(), payIn.getPayInDate(), payIn.getPayInMoney(),
                    payIn.getNote(), payIn.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(null, null, connection);
        }
        return true;
    }

    //payout表中删除一条记录（payout表中的id作为参数）。
    public boolean deletePayOut(int id) {
        try {
            connection = JDBCTools.getConnection();
            String sql = "delete from payout where id=?";
            JDBCTools.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(null, null, connection);
        }
        return true;
    }

    //payin表中删除一条记录（payin表中的id作为参数）。
    public boolean deletePayIn(int id) {
        try {
            connection = JDBCTools.getConnection();
            String sql = "delete from payin where id=?";
            JDBCTools.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(null, null, connection);
        }
        return true;
    }

    @Override
    public List<PayOut> selectPayOut(User user) {
        List<PayOut> payOutList = new ArrayList<>();
        String sql="select * from payout where userId = ?";
        try {
            connection=JDBCTools.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resultSet=JDBCTools.query(sql,user.getId());
        try {
            while (resultSet.next())
            {
                int id=resultSet.getInt(1);
                String payOutDate=resultSet.getString(2);
                float payOutMoney=resultSet.getFloat(3);
                String payOutCategory=resultSet.getString(4);
                int userid=resultSet.getInt(5);
                String note = resultSet.getString(6);
                PayOut payOut = new PayOut(id,payOutDate,payOutMoney,payOutCategory,userid,note);
                payOutList.add(payOut);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.releaseDB(resultSet,null,connection);
        }
        return payOutList;
    }

    @Override
    public List<PayIn> selectPayIn(User user) {
        List<PayIn> payInList = new ArrayList<>();
        String sql="select * from payin where userId = ?";
        try {
            connection=JDBCTools.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resultSet=JDBCTools.query(sql,user.getId());
        try {
            while (resultSet.next())
            {
                int id=resultSet.getInt(1);
                String payInDate=resultSet.getString(2);
                float payInMoney=resultSet.getFloat(3);
                String note = resultSet.getString(4);
                int userId = resultSet.getInt(5);
                PayIn payIn = new PayIn(id,payInDate,payInMoney,note,userId);
                payInList.add(payIn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.releaseDB(resultSet,null,connection);
        }
        return payInList;
    }


    //用户修改自己的payout记录
    public boolean changePayOut(PayOut payOut) {
        try {
            connection = JDBCTools.getConnection();
            String sql = "update payout set payOutDate=?,payOutMoney=?,payOutCategory=?,userId=?,note=? where id=?";
            JDBCTools.update(sql, payOut.getPayOutDate(), payOut.getPayOutMoney(), payOut.getPayOutCategory(),
                    payOut.getUserId(), payOut.getNote(), payOut.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(null, null, connection);
        }
        return true;
    }

    //用户修改自己的payin记录
    public boolean changePayIn(PayIn payIn) {
        try {
            connection = JDBCTools.getConnection();
            String sql = "update payin set payInDate=?,payInMoney=?,note=?,userId=? where id=?";
            JDBCTools.update(sql, payIn.getPayInDate(), payIn.getPayInMoney(), payIn.getNote(),
                    payIn.getUserId(), payIn.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(null, null, connection);
        }
        return true;
    }

    public static void main(String[] args) {
        PayInOutDao payInOut = new PayInOutImpl();
        User user =new User();
        user.setId(12);
        /*List<PayOut> payOutList= payInOut.selectPayOut(user);*/
        List<PayIn> payInList = payInOut.selectPayIn(user);
       /* for (int i=0;i<payOutList.size();i++)
        {
            System.out.println(payOutList.get(i));
        }*/
        for (int i=0;i<payInList.size();i++)
        {
            System.out.println(payInList.get(i));
        }
    }
}
