package com.ridvan.lovenue.models.model;

import java.util.List;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class RelevantVenuesResponse {
    private String headerFullLocation;
    private List<Group> groups;
    private Integer totalResults;

    public String getHeaderFullLocation() {
        return headerFullLocation;
    }

    public void setHeaderFullLocation(String headerFullLocation) {
        this.headerFullLocation = headerFullLocation;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
}
