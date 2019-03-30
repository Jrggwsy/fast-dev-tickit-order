package com.irinnovative.onepagesigninsignup.sql;


/**
 * Created by zxkj on 2018/11/13.
 */
public class User {

    private int _id;//用户信息表的主键，用于在数据库中存取用户个人信息

    private String userName;//用户名

    private String password;//密码

    private String numberId;//乘车人身份证号

    private String name;//乘车人真实姓名

    private String sex;//乘车人性别

    private String number;//乘车人手机号

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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
}
