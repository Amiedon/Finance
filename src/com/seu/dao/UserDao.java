package com.seu.dao;

import com.seu.entity.User;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Amie on 2017/3/1.
 */
public interface UserDao {
    public boolean add(User user);
    public boolean delete(int id);
    public boolean change(User user);
    public List<User> select();
    public List<User> findSimpleResult(String sql, Object...args);
    /*public boolean creatTable(User user);*/
}
