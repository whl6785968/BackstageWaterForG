package com.sandalen.water.bean;

import java.util.Date;

public class Equipment {
    private String id;

    private String name;

    private String model;

    private Date productiontime;

    private Integer availabletime;

    private String productionplace;

    private Integer status;

    private Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Date getProductiontime() {
        return productiontime;
    }

    public void setProductiontime(Date productiontime) {
        this.productiontime = productiontime;
    }

    public Integer getAvailabletime() {
        return availabletime;
    }

    public void setAvailabletime(Integer availabletime) {
        this.availabletime = availabletime;
    }

    public String getProductionplace() {
        return productionplace;
    }

    public void setProductionplace(String productionplace) {
        this.productionplace = productionplace == null ? null : productionplace.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}