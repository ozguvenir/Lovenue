package com.ridvan.lovenue.service;

import com.ridvan.lovenue.models.response.RelevantVenuesResponseModel;
import com.ridvan.lovenue.models.response.VenueDetailResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
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
            @Query("price") String price,
            @Query("openNow") String openNow,
            @Query("sortByDistance") String sortByDistance,
            @Query("limit") String limit);

    @GET("venues/{venue_id}?")
    Call<VenueDetailResponseModel> getVenueDetail(
            @Path("venue_id") String venueId,
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("v") String v);
}
