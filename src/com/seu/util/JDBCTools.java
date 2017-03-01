package com.seu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Amie on 2017/3/01 0028.
 */
public class JDBCTools {
    //获取数据库连接的方法
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        //0. 读取 jdbc.properties
        /**
         * 1). 属性文件对应 Java 中的 Properties 类 2). 可以使用类加载器加载 bin 目录(类路径下)的文件
         */
      /*  Properties properties=new Properties();
        InputStream inputStream=JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(inputStream);
        // 1. 准备获取连接的 4 个字符串: user, password, jdbcUrl, driverClass
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String jdbcUrl=properties.getProperty("jdbcUrl");
        String driverClass=properties.getProperty("driverClass");

        //2、加载驱动
        Class.forName(driverClass);
        //3、调用DriverManager.getConnection(jdbcUrl, user, password)
        // 获取数据库连接
        Connection connection= DriverManager.getConnection(jdbcUrl,user,password);*/
        String url="jdbc:mysql://localhost:3306/register";
        String username="root";
        String password="";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,username,password);
        //System.out.println("success！");
        return connection;
    }

    //释放资源的方法:@param resultSet @param statement @param connection
    public static void releaseDB(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //通用的更新方法，包括：update、insert、delete
    public static void update(String sql,Object... args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=JDBCTools.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            JDBCTools.releaseDB(null,preparedStatement,connection);
        }
    }
    //查询方法
    public static ResultSet query(String sql,Object...args){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection=JDBCTools.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet=preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }  /*finally {
            JDBCTools.releaseDB(resultSet,preparedStatement,connection);
        }*/
        return  resultSet;
    }

    /*处理数据库事务*/
    //提交事务：
    public static void commit(Connection connection){
        if (connection!=null){
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //回滚事务：
    public static void rollback(Connection connection){
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
