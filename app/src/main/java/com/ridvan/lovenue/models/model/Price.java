package com.ridvan.lovenue.models.model;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class Price {
    private Integer tier;
    private String message;
    private String currency;

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
