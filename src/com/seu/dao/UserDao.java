package com.seu.dao;

import com.seu.entity.User;

import java.util.List;

/**
 * Created by Amie on 2017/3/1.
 */
public interface UserDao {
    public boolean add(User user);
    public boolean delete(int id);
    public boolean change(User user);
    public List<User> select();
}
