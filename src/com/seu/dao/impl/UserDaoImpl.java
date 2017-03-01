package com.seu.dao.impl;

import com.seu.dao.UserDao;
import com.seu.entity.User;
import com.seu.util.JDBCTools;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amie on 2017/3/1.
 */
public class UserDaoImpl implements UserDao {

    Connection connection=null;
    ResultSet resultSet=null;
    @Override
    public boolean add(User user) {
        try {
            connection = JDBCTools.getConnection();
            /*String sql="insert into user(id,userName,password,email,photo) " +
                    "values(?,?,?,?,?)";
            JDBCTools.update(sql,user.getId(),user.getUserName(),user.getPassword(),
                    user.getEmail(), user.getPhoto());*/
            String sql="insert into user(userName,password,email,photo) " +
                    "values(?,?,?,?)";
            JDBCTools.update(sql,user.getUserName(),user.getPassword(),
                    user.getEmail(), user.getPhoto());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.releaseDB(null,null,connection);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            connection=JDBCTools.getConnection();
            String sql="delete from user where id=?";
            JDBCTools.update(sql,id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.releaseDB(null,null,connection);
        }
        return true;
    }

    @Override
    public boolean change(User user) {
        try {
            connection=JDBCTools.getConnection();
            String sql="update user set id=?,userName=?,password=?,email=?,photo=?";
            JDBCTools.update(sql,user.getId(),user.getUserName(),user.getPassword(),
                    user.getEmail(), user.getPhoto());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.releaseDB(null,null,connection);
        }
        return true;
    }

    @Override
    public List<User> select() {
        List<User> list=new ArrayList<>();
        String sql="select * from user";
        Object[] objects={};
        resultSet=JDBCTools.query(sql,objects);
        try {
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String userName=resultSet.getString(2);
                String password=resultSet.getString(3);
                String email=resultSet.getString(4);
                String photo=resultSet.getString(5);
                User user=new User(id,userName,password,email,photo);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.releaseDB(resultSet,null,connection);
        }
        return list;
    }

    @Override
    public List<User> findSimpleResult(String sql, Object...args) {
        List<User> list=new ArrayList<>();
        try {
            connection=JDBCTools.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resultSet=JDBCTools.query(sql,args);
        try {
            while (resultSet.next())
            {
                int id=resultSet.getInt(1);
                String userName=resultSet.getString(2);
                String password=resultSet.getString(3);
                String email=resultSet.getString(4);
                String photo=resultSet.getString(5);
                User user=new User(id,userName,password,email,photo);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCTools.releaseDB(resultSet,null,connection);
        }
        return list;
    }
}
