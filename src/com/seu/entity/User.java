package com.seu.entity;

/**
 * Created by Amie on 2017/3/01 0028.
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String photo;
    private int state;///用户的状态0未激活 1 已激活
    private String code;//用户用于邮箱验证的激活码 0未激活

    public User() {
        super();
    }

    public User(int id, String userName, String password, String email, String photo,int state,String code) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.photo = photo;
        this.state = state;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (state != user.state) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (photo != null ? !photo.equals(user.photo) : user.photo != null) return false;
        return code != null ? code.equals(user.code) : user.code == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + state;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}
