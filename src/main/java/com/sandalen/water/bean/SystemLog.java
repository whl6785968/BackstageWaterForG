package com.sandalen.water.bean;

import java.util.Date;

public class SystemLog {
    private Integer id;

    private String itr;

    private String behavior;

    private String ip;

    private String ipOrigin;

    private String browser;

    private Date createTime;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItr() {
        return itr;
    }

    public void setItr(String itr) {
        this.itr = itr == null ? null : itr.trim();
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior == null ? null : behavior.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getIpOrigin() {
        return ipOrigin;
    }

    public void setIpOrigin(String ipOrigin) {
        this.ipOrigin = ipOrigin == null ? null : ipOrigin.trim();
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}