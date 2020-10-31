package com.sandalen.water.bean;

import java.util.Date;

public class NewestWaterData {
    public String district;
    public String province;
    public int id;
    public String station;
    public int status;
    public double ph;
    public double dis;
    public double nh;
    public double kmno;
    public double totalp;
    public int level;
    public Date createTime;

    public double getNh() {
        return nh;
    }

    public void setNh(double nh) {
        this.nh = nh;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double dis) {
        this.dis = dis;
    }

    public double getKmno() {
        return kmno;
    }

    public void setKmno(double kmno) {
        this.kmno = kmno;
    }

    public double getTotalp() {
        return totalp;
    }

    public void setTotalp(double totalp) {
        this.totalp = totalp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
