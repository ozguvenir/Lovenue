package com.ridvan.lovenue;

import retrofit2.Retrofit;

/**
 * Created by ridvanozguvenir on 16.08.2018.
 */
public final class ServiceContext {
    public static ServiceContext instance;
    public final Retrofit retrofit;

    private ServiceContext(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public static void initialize(Retrofit retrofit) {
        if (instance != null) throw new IllegalStateException("ServiceContext already initialized");
        ServiceContext.instance = new ServiceContext(retrofit);
    }
}