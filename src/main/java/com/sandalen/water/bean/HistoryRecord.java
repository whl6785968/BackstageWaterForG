package com.sandalen.water.bean;

public class HistoryRecord {
    private Integer id;

    private String sid;

    private String name;

    private Integer currLevel;

    private Integer preLevel;

    private String responsible;

    private String did;

    private String dname;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(Integer currLevel) {
        this.currLevel = currLevel;
    }

    public Integer getPreLevel() {
        return preLevel;
    }

    public void setPreLevel(Integer preLevel) {
        this.preLevel = preLevel;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible == null ? null : responsible.trim();
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}