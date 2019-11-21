package com.sandalen.water.bean;

public class Station {
    private String id;

    private String name;

    private Double longtitude;

    private Double latitude;

    private Integer currlevel;

    private Integer prelevel;

    private String responsible;

    private Userinfo userinfo;

    private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getCurrlevel() {
        return currlevel;
    }

    public void setCurrlevel(Integer currlevel) {
        this.currlevel = currlevel;
    }

    public Integer getPrelevel() {
        return prelevel;
    }

    public void setPrelevel(Integer prelevel) {
        this.prelevel = prelevel;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible == null ? null : responsible.trim();
    }
}