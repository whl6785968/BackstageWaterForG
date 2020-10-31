package com.sandalen.water.bean;

import java.util.ArrayList;

public class SingleEntity{
    private long entityId;
    private String entityName;
    private String entityAmbiguous;
    private ArrayList<String> entity_label;
    private String entityLink;

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityAmbiguous() {
        return entityAmbiguous;
    }

    public void setEntityAmbiguous(String entityAmbiguous) {
        this.entityAmbiguous = entityAmbiguous;
    }

    public ArrayList<String> getEntity_label() {
        return entity_label;
    }

    public void setEntity_label(ArrayList<String> entity_label) {
        this.entity_label = entity_label;
    }

    public String getEntityLink() {
        return entityLink;
    }

    public void setEntityLink(String entityLink) {
        this.entityLink = entityLink;
    }
}
