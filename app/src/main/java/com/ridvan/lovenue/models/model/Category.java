package com.ridvan.lovenue.models.model;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class Category {
    private String id;
    private String name;
    private String pluralName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }
}
