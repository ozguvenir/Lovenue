package com.ridvan.lovenue;

import android.app.Application;

import com.ridvan.lovenue.constants.LovenueConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public class LovenueApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // initializing service and retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LovenueConstants.FOURSQUARE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceContext.initialize(retrofit);
    }
}
