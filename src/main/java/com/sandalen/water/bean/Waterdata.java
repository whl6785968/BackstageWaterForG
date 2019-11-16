package com.sandalen.water.bean;

public class Waterdata {
    private Integer id;

    private Double ph;

    private Double disslove;

    private Double nh;

    private Double kmno;

    private Double totalp;

    private String eid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getDisslove() {
        return disslove;
    }

    public void setDisslove(Double disslove) {
        this.disslove = disslove;
    }

    public Double getNh() {
        return nh;
    }

    public void setNh(Double nh) {
        this.nh = nh;
    }

    public Double getKmno() {
        return kmno;
    }

    public void setKmno(Double kmno) {
        this.kmno = kmno;
    }

    public Double getTotalp() {
        return totalp;
    }

    public void setTotalp(Double totalp) {
        this.totalp = totalp;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }
}