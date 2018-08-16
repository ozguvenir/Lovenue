package com.ridvan.lovenue.models.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class Venue {
    private String id;
    private String name;
    private Contact contact;
    private Location location;
    private List<Category> categories = new ArrayList<Category>();
    private Price price;
    private Double rating;
    private String ratingColor;
    private String url;

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
