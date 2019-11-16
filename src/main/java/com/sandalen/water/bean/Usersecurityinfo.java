package com.sandalen.water.bean;

import java.util.Date;

public class Usersecurityinfo {
    private Integer id;

    private Integer locked;

    private Integer enabled;

    private Integer attemped;

    private Integer isaccountexpired;

    private Date createdtime;

    private String uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getAttemped() {
        return attemped;
    }

    public void setAttemped(Integer attemped) {
        this.attemped = attemped;
    }

    public Integer getIsaccountexpired() {
        return isaccountexpired;
    }

    public void setIsaccountexpired(Integer isaccountexpired) {
        this.isaccountexpired = isaccountexpired;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}