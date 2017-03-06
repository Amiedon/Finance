package com.seu.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/3/2 0002.
 */
public class PayIn {
    private int id;
    private String payInDate;
    private float payInMoney;
    private String note;
    private int userId;

    public PayIn() {
    }
    public PayIn( String payInDate, float payInMoney, String note,int userId) {
        this.payInDate = payInDate;
        this.payInMoney = payInMoney;
        this.note = note;
        this.userId=userId;
    }


    public PayIn(int id, String payInDate, float payInMoney, String note, int userId) {
        this.id = id;
        this.payInDate = payInDate;
        this.payInMoney = payInMoney;
        this.note = note;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayInDate() {
        return payInDate;
    }

    public void setPayInDate(String payInDate) {
        this.payInDate = payInDate;
    }





    public float getPayInMoney() {
        return payInMoney;
    }

    public void setPayInMoney(float payInMoney) {
        this.payInMoney = payInMoney;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PayIn{" +
                "id=" + id +
                ", payInDate=" + payInDate +
                ", payInMoney=" + payInMoney +
                ", note='" + note + '\'' +
                ", userId=" + userId +
                '}';
    }
}
