package com.ridvan.lovenue.models.response;

import com.ridvan.lovenue.models.model.VenueDetailResponse;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class VenueDetailResponseModel extends BaseResponseModel {
    private VenueDetailResponse response;

    public VenueDetailResponse getResponse() {
        return response;
    }

    public void setResponse(VenueDetailResponse response) {
        this.response = response;
    }
}
