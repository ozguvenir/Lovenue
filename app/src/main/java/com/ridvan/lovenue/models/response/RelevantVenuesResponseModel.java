package com.ridvan.lovenue.models.response;

import com.ridvan.lovenue.models.model.RelevantVenuesResponse;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class RelevantVenuesResponseModel extends BaseResponseModel {
    private RelevantVenuesResponse response;

    public RelevantVenuesResponse getResponse() {
        return response;
    }

    public void setResponse(RelevantVenuesResponse response) {
        this.response = response;
    }
}
