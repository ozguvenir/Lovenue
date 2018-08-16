package com.ridvan.lovenue.models.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class Group {
    private String type;
    private String name;
    private List<Items> items = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
