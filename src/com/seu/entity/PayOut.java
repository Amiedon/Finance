package com.seu.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/2 0002.
 */
public class PayOut {
    private int id;
    private String payOutDate;
    private float payOutMoney;
    private String payOutCategory;
    private int userId;
    private String note;

    public PayOut() {
    }
    public PayOut(String payOutDate, float payOutMoney, String payOutCategory,int userId,String note) {
        this.payOutDate = payOutDate;
        this.payOutMoney = payOutMoney;
        this.payOutCategory = payOutCategory;
        this.userId=userId;
        this.note = note;

    }


    public PayOut(int id, String payOutDate, float payOutMoney, String payOutCategory, int userId, String note) {
        this.id = id;
        this.payOutDate = payOutDate;
        this.payOutMoney = payOutMoney;
        this.payOutCategory = payOutCategory;
        this.userId = userId;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayOutDate() {
        return payOutDate;
    }

    public void setPayOutDate(String payOutDate) {
        this.payOutDate = payOutDate;
    }

    public float getPayOutMoney() {
        return payOutMoney;
    }

    public void setPayOutMoney(float payOutMoney) {
        this.payOutMoney = payOutMoney;
    }

    public String getPayOutCategory() {
        return payOutCategory;
    }

    public void setPayOutCategory(String payOutCategory) {
        this.payOutCategory = payOutCategory;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PayOut{" +
                "id=" + id +
                ", payOutDate=" + payOutDate +
                ", payOutMoney=" + payOutMoney +
                ", payOutCategory=" + payOutCategory +
                ", userId=" + userId +
                ", note='" + note + '\'' +
                '}';
    }
}
