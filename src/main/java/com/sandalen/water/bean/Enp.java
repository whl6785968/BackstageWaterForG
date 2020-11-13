package com.sandalen.water.bean;

public class Enp {
    private Integer id;

    private String name;

    private String contacts;

    private String contactsNumber;

    private String mainPollutions;

    private Double pollutionsNum;

    private Integer isExceed;

    private String exceedFactor;

    private Station station;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactsNumber() {
        return contactsNumber;
    }

    public void setContactsNumber(String contactsNumber) {
        this.contactsNumber = contactsNumber == null ? null : contactsNumber.trim();
    }

    public String getMainPollutions() {
        return mainPollutions;
    }

    public void setMainPollutions(String mainPollutions) {
        this.mainPollutions = mainPollutions == null ? null : mainPollutions.trim();
    }

    public Double getPollutionsNum() {
        return pollutionsNum;
    }

    public void setPollutionsNum(Double pollutionsNum) {
        this.pollutionsNum = pollutionsNum;
    }

    public Integer getIsExceed() {
        return isExceed;
    }

    public void setIsExceed(Integer isExceed) {
        this.isExceed = isExceed;
    }

    public String getExceedFactor() {
        return exceedFactor;
    }

    public void setExceedFactor(String exceedFactor) {
        this.exceedFactor = exceedFactor == null ? null : exceedFactor.trim();
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}