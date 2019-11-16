package com.sandalen.water.bean;

public class Station {
    private String id;

    private String name;

    private Double longtitude;

    private Double latitude;

    private Integer currlevel;

    private Integer prelevel;

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
}