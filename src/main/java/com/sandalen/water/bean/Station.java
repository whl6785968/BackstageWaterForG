package com.sandalen.water.bean;

public class Station {
    private String id;

    private String name;

    private Double longtitude;

    private Double latitude;

    private Integer currlevel;

    private Integer prelevel;

    private String responsible;

    private String upstreamId;

    private String downstreamId;

    private Integer isAlert;

    private Userinfo userinfo;

    private District district;

    private ErrRecord errRecord;

    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public ErrRecord getErrRecord() {
        return errRecord;
    }

    public void setErrRecord(ErrRecord errRecord) {
        this.errRecord = errRecord;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
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

    public String getUpstreamId() {
        return upstreamId;
    }

    public void setUpstreamId(String upstreamId) {
        this.upstreamId = upstreamId == null ? null : upstreamId.trim();
    }

    public String getDownstreamId() {
        return downstreamId;
    }

    public void setDownstreamId(String downstreamId) {
        this.downstreamId = downstreamId == null ? null : downstreamId.trim();
    }

    public Integer getIsAlert() {
        return isAlert;
    }

    public void setIsAlert(Integer isAlert) {
        this.isAlert = isAlert;
    }

}