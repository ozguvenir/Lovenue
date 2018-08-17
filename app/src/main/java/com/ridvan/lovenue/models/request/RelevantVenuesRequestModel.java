package com.ridvan.lovenue.models.request;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class RelevantVenuesRequestModel extends BaseRequestModel {
    private String ll;
    private String near;
    private String radius;
    private String section;
    private String price;
    private String openNow;
    private String sortByDistance;

    public RelevantVenuesRequestModel() {
    }

    public RelevantVenuesRequestModel(String ll, String near, String radius, String section, String price, String openNow, String sortByDistance) {
        this.ll = ll;
        this.near = near;
        this.radius = radius;
        this.section = section;
        this.price = price;
        this.openNow = openNow;
        this.sortByDistance = sortByDistance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }

    public String getNear() {
        return near;
    }

    public void setNear(String near) {
        this.near = near;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getOpenNow() {
        return openNow;
    }

    public void setOpenNow(String openNow) {
        this.openNow = openNow;
    }

    public String getSortByDistance() {
        return sortByDistance;
    }

    public void setSortByDistance(String sortByDistance) {
        this.sortByDistance = sortByDistance;
    }
}
