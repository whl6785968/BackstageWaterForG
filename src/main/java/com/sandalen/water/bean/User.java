package com.sandalen.water.bean;

public class User {
    private String userid;

    private String pwd;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Userinfo userinfo;

    public Usersecurityinfo usersecurityinfo;

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public Usersecurityinfo getUsersecurityinfo() {
        return usersecurityinfo;
    }

    public void setUsersecurityinfo(Usersecurityinfo usersecurityinfo) {
        this.usersecurityinfo = usersecurityinfo;
    }
}