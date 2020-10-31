package com.sandalen.water.bean;

import java.util.ArrayList;

public class Entity4Neo {
    private long entityId;
    private String entity;
    private String entityAmbiguous;
    private ArrayList<String> entity_label;
    private String entityLink;
    private long relationId;
    private String relation;
    private long valueId;
    private String value;
    private String valueAmbiguous;
    private ArrayList<String> value_label;
    private String valueLink;
    private String desc;

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public long getValueId() {
        return valueId;
    }

    public void setValueId(long valueId) {
        this.valueId = valueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueAmbiguous() {
        return valueAmbiguous;
    }

    public void setValueAmbiguous(String valueAmbiguous) {
        this.valueAmbiguous = valueAmbiguous;
    }

    public ArrayList<String> getValue_label() {
        return value_label;
    }

    public void setValue_label(ArrayList<String> value_label) {
        this.value_label = value_label;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValueLink() {
        return valueLink;
    }

    public void setValueLink(String valueLink) {
        this.valueLink = valueLink;
    }

    public long getRelationId() {
        return relationId;
    }

    public void setRelationId(long relationId) {
        this.relationId = relationId;
    }
}
