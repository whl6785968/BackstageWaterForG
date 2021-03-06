package com.sandalen.water.bean;

import java.util.Date;

public class Waterdata {
    private Integer id;

    private Double ph;

    private Double disslove;

    private Double nh;

    private Double kmno;

    private Double totalp;

    private Date createTame;

    private String eid;

    private Integer level;

    private String formatDate;

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

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

    public Date getCreateTame() {
        return createTame;
    }

    public void setCreateTame(Date createTame) {
        this.createTame = createTame;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        return this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if(null == obj){
            return false;
        }

        if(obj instanceof Waterdata){
            Waterdata other = (Waterdata) obj;
            return this.getId() == other.getId();
        }
        return false;
    }
}