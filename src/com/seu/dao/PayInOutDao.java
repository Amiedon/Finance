package com.seu.dao;


import com.seu.entity.PayIn;
import com.seu.entity.PayOut;
import com.seu.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */
public interface PayInOutDao {
    public boolean addPayOut(PayOut payOut);
    public boolean addPayIn(PayIn payIn);
    public boolean deletePayOut(int id);
    public boolean deletePayIn(int id);
    public List<PayOut> selectPayOut(User user);
    public List<PayIn> selectPayIn(User user);
    public boolean changePayOut(PayOut payOut);
    public boolean changePayIn(PayIn payIn);
}
