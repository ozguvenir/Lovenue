package com.ridvan.lovenue.Service;

import com.ridvan.lovenue.models.response.RelevantVenuesResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public interface FoursquareService {

    // getRelevantVenues method can be used for both list and search
    @GET("venues/explore?")
    Call<RelevantVenuesResponseModel> getRelevantVenues(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("ll") String ll,
            @Query("near") String near,
            @Query("v") String version,
            @Query("radius") String radius,
            @Query("section") String section,
            @Query("openNow") String openNow,
            @Query("sortByDistance") String sortByDistance,
            @Query("limit") String limit);
}
